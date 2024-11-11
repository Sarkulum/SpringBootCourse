package com.example.springbootcourse.service

import com.example.springbootcourse.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BankServiceTest{
    val dataSource : BankDataSource = mockk()
    val bankService = BankService(dataSource)
    @Test
    fun `should call data source`(){
        //given
        every { dataSource.retrieveBanks() } returns emptyList()
        //when
        val banks = bankService.getBanks()
        //then
        verify(exactly = 1) { dataSource.retrieveBanks() }
    }
}