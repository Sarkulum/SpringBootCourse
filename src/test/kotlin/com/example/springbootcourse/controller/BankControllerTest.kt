package com.example.springbootcourse.controller

import com.example.springbootcourse.model.Bank
import com.example.springbootcourse.service.BankService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
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
    fun `should return Bad Request`(){
        //given


    }
}