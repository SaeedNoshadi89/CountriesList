package com.sn.scaniatest.domain.usecase

import com.sn.scaniatest.data.util.Resource
import com.sn.scaniatest.domain.model.Countries
import com.sn.scaniatest.domain.repository.ICountriesListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(private val repository: ICountriesListRepository) {
    operator fun invoke(): Flow<Resource<List<Countries>>> = repository.getAllCountries()
}