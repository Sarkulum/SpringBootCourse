package com.example.springbootcourse.datasource.mock

import com.example.springbootcourse.model.Bank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import com.example.springbootcourse.service.BankService

class MockBankDataSourceTest {

    private val mockDataSource = MockBankDataSource()

    @Test
    fun `should provide collection of banks`(){
        //when
        val banks = mockDataSource.retrieveBanks()
        //then
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data`(){
        //when
        val banks = mockDataSource.retrieveBanks()

        //then
        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        assertThat(banks).anyMatch { it.trust != 0.0 }
        assertThat(banks).anyMatch { it.transactionFee != 0}
    }
}