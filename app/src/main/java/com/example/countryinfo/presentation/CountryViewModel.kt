package com.example.countryinfo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryinfo.domain.usecase.GetCountryDetailUseCase
import com.example.countryinfo.domain.usecase.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val getCountryDetailUseCase: GetCountryDetailUseCase,
    private val getCountryUseCase: GetCountryUseCase
) : ViewModel() {

    private val _countryState = MutableStateFlow(CountryState())
    val countryState = _countryState.asStateFlow()

    init {
        viewModelScope.launch {
            _countryState.update {
                it.copy(
                    isLoading = true
                )
            }
            _countryState.update {
                it.copy(
                    countryList = getCountryUseCase.getCountry(),
                    isLoading = false
                )
            }
        }
    }

    fun getSelectedCountry(code: String) {
        viewModelScope.launch {
            _countryState.update {
                it.copy(
                    selectedCountry = getCountryDetailUseCase.getCountryDetail(code)
                )
            }
        }
    }

    fun dismissCountryDialog() {
        _countryState.update {
            it.copy(
                selectedCountry = null
            )
        }
    }
}