package com.example.springbootcourse.service

import com.example.springbootcourse.datasource.BankDataSource
import com.example.springbootcourse.model.Bank
import org.springframework.stereotype.Service
import javax.sql.DataSource

@Service
class BankService(val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> {
        return dataSource.retrieveBanks()
    }

    fun getBank(accountNumber: String): Bank = dataSource.retrieveBanks(accountNumber)
    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)
    fun updateBank(bank: Bank): Bank = dataSource.addUpdatedBank(bank)
    fun deleteBank(accountNumber: String) :Unit = dataSource.deleteBank(accountNumber)

}