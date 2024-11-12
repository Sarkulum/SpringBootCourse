package com.example.springbootcourse.controller

import com.example.springbootcourse.model.Bank
import com.example.springbootcourse.service.BankService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity.notFound
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.patch
import org.springframework.test.web.servlet.post
import java.awt.PageAttributes
import javax.management.Query.value
import kotlin.test.Test

@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `should return all banks`(){
        //when/then
        mockMvc.get("/api/banks")
            .andDo{ print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].accountNumber") {
                    value("Valerie")
                }
            }
    }

    @Test
    fun `should return the bank and given account number`() {
        //given
        val accountNumber = "Valerie"
        //when/then
        mockMvc.get("/api/banks/$accountNumber")
            .andDo{ print() }
            .andExpect { status {
                isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.trust") { value("100.0") }
                jsonPath("$.transactionFee") { value("50")}
            }
    }

    @Test
    fun `should add new bank`(){
        //given
        val newBank = Bank("Hans", 234.234, 5)
        //when
        val performPost = mockMvc.post("/api/banks"){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBank)
        }
        //then
            performPost
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.accountNumber") { value("Hans") }
                    jsonPath("$.trust") { value(234.234) }
                    jsonPath("$.transactionFee") { value(5) }
            }
    }

    @Test
    fun `should return Bad Request if already exists`(){
        //given
        val invalidBank = Bank("Valerie", 1.0, 1)

        //when
        val performPost = mockMvc.post("/api/banks"){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(invalidBank)
        }

        //then
        performPost
            .andDo { print() }
            .andExpect { status { isBadRequest() } }
    }

    @Test
    fun `update bank`(){
        //given
        val updatedBank = Bank("Valerie", 1312.0, 1)
        //when
        val performPatch = mockMvc.patch("/api/banks"){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(updatedBank)
        }
        //then
        performPatch
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    json(objectMapper.writeValueAsString(updatedBank))
                }
            }

        mockMvc.get("/api/banks/${updatedBank.accountNumber}")
            .andExpect { content { json(objectMapper.writeValueAsString(updatedBank))} }
    }

    @Test
    fun `should return BAD Request if no bank`(){
        //given
        val invalidBank = Bank("Walrus", 1.1 ,1)
        //when
        val performInvalidPatchRequest = mockMvc.patch("/api/banks") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(invalidBank)
        }
        //then
        performInvalidPatchRequest
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }
}