package com.example.springbootcourse.datasource

import com.example.springbootcourse.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
    fun retrieveBanks(accountNumber: String): Bank
    fun createBank(bank: Bank): Bank
    fun addUpdatedBank(bank: Bank): Bank
    fun deleteBank(accountNumber: String) : Unit
}