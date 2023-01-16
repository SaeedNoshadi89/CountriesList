package com.sn.scaniatest.presentation.country_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sn.scaniatest.data.util.Status
import com.sn.scaniatest.domain.model.Countries
import com.sn.scaniatest.domain.usecase.GetCountryDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    private val getCountryDetailUseCase: GetCountryDetailUseCase
) : ViewModel() {

    private val _country  = MutableStateFlow(Countries())
    val country : StateFlow<Countries> = _country

    private val _state = MutableStateFlow(Status.LOADING)
    val state: StateFlow<Status> = _state

    fun getCountryDetail(name: String){
        viewModelScope.launch {
            getCountryDetailUseCase(name).collect { result ->
                 when (result.status) {
                     Status.LOADING -> _state.value = Status.LOADING
                     Status.SUCCESS -> {
                         _state.value = Status.SUCCESS
                         _country.value = result.data ?: Countries()
                     }
                     Status.ERROR -> _state.value = Status.ERROR
                 }
            }
        }
    }

}
