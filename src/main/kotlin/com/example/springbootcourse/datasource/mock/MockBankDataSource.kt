package com.example.springbootcourse.datasource.mock

import com.example.springbootcourse.datasource.BankDataSource
import com.example.springbootcourse.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    val banks = listOf(
        Bank("Valerie", 100.0, 50),
        Bank("Peter", 222.50, 40),
        Bank("Uwe", 432.23, 73),
    )
    override fun retrieveBanks() : Collection<Bank> = banks
}
