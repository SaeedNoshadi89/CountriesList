package com.sn.scaniatest.data.repository

import com.sn.scaniatest.data.util.Resource
import com.sn.scaniatest.domain.model.*
import com.sn.scaniatest.domain.repository.ICountriesListRepository
import com.sn.scaniatest.domain.repository.ICountryDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Assert.*

import org.junit.Test

class FakeCountryDetailRepository : ICountryDetailRepository {
    val countryList = Countries(
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

    override fun getCountryDetail(name: String): Flow<Resource<Countries>> = flow {
        if (countryList.name?.common == name){
            emit(Resource.success(countryList))
        }else{
            emit(Resource.success(Countries()))
        }
    }
}