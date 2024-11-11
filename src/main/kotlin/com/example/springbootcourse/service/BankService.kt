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

}