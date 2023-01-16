package com.sn.scaniatest.data.api

import com.sn.scaniatest.data.model.NetworkCountries


interface NetworkDataSource {
    suspend fun getAllCountries(): List<NetworkCountries>
    suspend fun getCountryDetail(name: String): List<NetworkCountries>
}