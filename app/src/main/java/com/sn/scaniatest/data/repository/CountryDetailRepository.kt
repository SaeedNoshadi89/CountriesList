package com.sn.scaniatest.data.repository

import com.sn.scaniatest.data.api.NetworkDataSource
import com.sn.scaniatest.data.util.Resource
import com.sn.scaniatest.domain.model.Countries
import com.sn.scaniatest.domain.repository.ICountryDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountryDetailRepository @Inject constructor(
    private val network: NetworkDataSource
) : ICountryDetailRepository {

    override fun getCountryDetail(name: String): Flow<Resource<Countries>> = flow{
        emit(Resource.loading())
        runCatching {
            network.getCountryDetail(name)
        }.onSuccess {
            if (it.size > 0){
                val mapCountries = it.firstOrNull()?.asCountries()
                emit(Resource.success(mapCountries))
            }
        }.onFailure {
            emit(Resource.error(it.message.toString()))
        }
    }
}