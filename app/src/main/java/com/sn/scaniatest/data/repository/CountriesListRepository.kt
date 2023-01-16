package com.sn.scaniatest.data.repository

import com.sn.scaniatest.data.api.NetworkDataSource
import com.sn.scaniatest.data.util.Resource
import com.sn.scaniatest.domain.model.Countries
import com.sn.scaniatest.domain.repository.ICountriesListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountriesListRepository @Inject constructor(
    private val network: NetworkDataSource
) : ICountriesListRepository {
    override fun getAllCountries(): Flow<Resource<List<Countries>>> = flow {
        emit(Resource.loading())
        runCatching {
            network.getAllCountries()
        }.onSuccess {
            val mapCountries = it.map { country -> country.asCountries() }
            emit(Resource.success(mapCountries))
        }.onFailure {
            emit(Resource.error(it.message.toString()))
        }
    }
}