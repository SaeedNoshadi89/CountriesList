package com.sn.scaniatest.domain.repository

import com.sn.scaniatest.data.util.Resource
import com.sn.scaniatest.domain.model.Countries
import kotlinx.coroutines.flow.Flow

interface ICountryDetailRepository {
    fun getCountryDetail(name: String): Flow<Resource<Countries>>
}