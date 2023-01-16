package com.sn.scaniatest.data.repository

import com.sn.scaniatest.data.util.Resource
import com.sn.scaniatest.domain.model.*
import com.sn.scaniatest.domain.repository.ICountriesListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Assert.*

import org.junit.Test

class FakeCountriesListRepository : ICountriesListRepository {
    val countryList = listOf<Countries>(
        Countries(
            capital = listOf("Tehran"),
            flag = "Iran",
            flags = Flags(png = "png", svg = "svg"),
            name = Name(
                common = "Iran",
                official = "Iran",
                nativeName = NativeName(
                    eng = EngX(
                        common = "common",
                        official = "official"
                    )
                ),
            ),
            population = 88_000_000,
            region = "Persian",
            timezones = listOf("UTC")
        ),
        Countries(
            capital = listOf("Berlin"),
            flag = "Germany",
            flags = Flags(png = "png", svg = "svg"),
            name = Name(
                common = "Germany",
                official = "Germany",
                nativeName = NativeName(
                    eng = EngX(
                        common = "common",
                        official = "official"
                    )
                ),
            ),
            population = 83_000_000,
            region = "deutsch",
            timezones = listOf("UTC")
        )
    )

    override fun getAllCountries(): Flow<Resource<List<Countries>>> = flow {
        emit(Resource.success(countryList))
    }

}