package com.sn.scaniatest.domain.usecase

import com.sn.scaniatest.data.util.Resource
import com.sn.scaniatest.domain.model.Countries
import com.sn.scaniatest.domain.repository.ICountryDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCountryDetailUseCase @Inject constructor(private val repository: ICountryDetailRepository) {

    operator fun invoke(name: String): Flow<Resource<Countries>> = repository.getCountryDetail(name)

}