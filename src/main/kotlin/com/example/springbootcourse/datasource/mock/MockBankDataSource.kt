package com.example.springbootcourse.datasource.mock

import com.example.springbootcourse.datasource.BankDataSource
import com.example.springbootcourse.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    val banks = mutableListOf(
        Bank("Valerie", 100.0, 50),
        Bank("Peter", 222.50, 40),
        Bank("Uwe", 432.23, 73),
    )
    override fun retrieveBanks() : Collection<Bank> = banks
    override fun retrieveBanks(accountNumber: String): Bank {
        return banks.first {it.accountNumber == accountNumber}
    }

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with accountNumber ${bank.accountNumber} already exists")
        }
        banks.add(bank)

        return bank
    }

    override fun addUpdatedBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Bank with accountNumber ${bank.accountNumber} not found")

        banks.remove(currentBank)
        banks.add(bank)
        return bank
    }
}
