package com.sn.scaniatest.presentation.countries_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sn.scaniatest.data.util.Status
import com.sn.scaniatest.domain.model.Countries
import com.sn.scaniatest.domain.usecase.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
    ) : ViewModel() {

    private val _countriesList = MutableStateFlow(emptyList<Countries>())
    val countriesList: StateFlow<List<Countries>> = _countriesList

    private val _state = MutableStateFlow(Status.LOADING)
    val state: StateFlow<Status> = _state


    init {
        viewModelScope.launch {
            getCountriesUseCase().collect { result ->
                when (result.status) {
                    Status.LOADING -> _state.value = Status.LOADING
                    Status.SUCCESS -> {
                        _state.value = Status.SUCCESS
                        _countriesList.value = result.data ?: emptyList()
                    }
                    Status.ERROR -> _state.value = Status.ERROR
                }
            }
        }
    }
}