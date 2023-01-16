package com.sn.scaniatest.domain.usecase

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.sn.scaniatest.data.repository.FakeCountriesListRepository
import com.sn.scaniatest.data.repository.FakeCountryDetailRepository
import com.sn.scaniatest.domain.repository.ICountriesListRepository
import com.sn.scaniatest.domain.repository.ICountryDetailRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetCountryDetailUseCaseTest{
    private lateinit var countryDetailUseCase: GetCountryDetailUseCase
    private lateinit var countryDetailRepository: ICountryDetailRepository

    @Before
    fun setUp() {
        countryDetailRepository = FakeCountryDetailRepository()
        countryDetailUseCase = GetCountryDetailUseCase(countryDetailRepository)
    }

    @Test
    fun `get germany country based on name`() = runTest{
        val name = "Germany"
        countryDetailUseCase(name).test {
            Truth.assertThat(awaitItem().data?.name?.common == name).isTrue()
            awaitComplete()
        }
    }

    @Test
    fun `country should not be null`() = runTest{
        val name = "Germany"
        countryDetailUseCase(name).test {
            Truth.assertThat(awaitItem().data).isNotNull()
            awaitComplete()
        }
    }

    @Test
    fun `country should not be null if it's not be currect`() = runTest{
        val name = "Iran"
        countryDetailUseCase(name).test {
            Truth.assertThat(awaitItem().data).isNotNull()
            awaitComplete()
        }
    }

    @Test
    fun `country name object should be null if it's not be currect`() = runTest{
        val name = "Iran"
        countryDetailUseCase(name).test {
            Truth.assertThat(awaitItem().data?.name).isNull()
            awaitComplete()
        }
    }
}