package com.sn.scaniatest.data.api

import com.sn.scaniatest.data.model.NetworkCountries
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KtorNetwork @Inject constructor() : NetworkDataSource {
    override suspend fun getAllCountries(): List<NetworkCountries> = try {
        KtorModule.provideKtor.use {
            it.get("all")
        }.body()
    } catch (e: Exception) {
        throw IllegalArgumentException(e.message)
    }

    override suspend fun getCountryDetail(name: String): List<NetworkCountries> = try {
        KtorModule.provideKtor.use {
            it.get("name/$name")
        }.body()
    } catch (e: Exception) {
        throw IllegalArgumentException(e.message)
    }
}
