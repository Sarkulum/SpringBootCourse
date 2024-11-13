package com.example.springbootcourse.controller

import com.example.springbootcourse.datasource.BankDataSource
import com.example.springbootcourse.model.Bank
import com.example.springbootcourse.service.BankService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/banks")
class BankController(
    dataSource: BankDataSource,
    @Qualifier("bankService") private val service: BankService
) : BankService(dataSource) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity("No banks found", HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }

    @GetMapping
    fun outputBank(): Collection<Bank> {
        return getBanks()
    }

    @GetMapping("/{accountNumber}")
    fun outputAccount(@PathVariable accountNumber: String) : Bank = service.getBank(accountNumber)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun addBank(@RequestBody bank: Bank): Bank = service.addBank(bank)

    @PatchMapping
    override fun updateBank(@RequestBody bank: Bank): Bank = service.updateBank(bank)

    @DeleteMapping("/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun deleteBank(@PathVariable accountNumber: String): Unit = service.deleteBank(accountNumber)
}