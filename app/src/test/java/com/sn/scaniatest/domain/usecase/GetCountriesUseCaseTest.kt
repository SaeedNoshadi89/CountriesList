package com.sn.scaniatest.domain.usecase

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.sn.scaniatest.data.repository.FakeCountriesListRepository
import com.sn.scaniatest.domain.repository.ICountriesListRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetCountriesUseCaseTest{
    private lateinit var countriesUseCase: GetCountriesUseCase
    private lateinit var countriesListRepository: ICountriesListRepository

    @Before
    fun setUp() {
        countriesListRepository = FakeCountriesListRepository()
        countriesUseCase = GetCountriesUseCase(countriesListRepository)
    }

    @Test
    fun `countries List is not null`() = runTest{
        countriesUseCase().test {
            Truth.assertThat(awaitItem().data).isNotNull()
            awaitComplete()
        }
    }

    @Test
    fun `countries List size is two`() = runTest{
        countriesUseCase().test {
            Truth.assertThat(awaitItem().data?.size == 2).isTrue()
            awaitComplete()
        }
    }

    @Test
    fun `first country is Iran`() = runTest{
        countriesUseCase().test {
            Truth.assertThat(awaitItem().data?.get(0)?.name?.common == "Iran").isTrue()
            awaitComplete()
        }
    }

}