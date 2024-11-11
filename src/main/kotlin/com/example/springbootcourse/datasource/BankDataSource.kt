package com.example.springbootcourse.datasource

import com.example.springbootcourse.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
    fun retrieveBanks(accountNumber: String): Bank
}