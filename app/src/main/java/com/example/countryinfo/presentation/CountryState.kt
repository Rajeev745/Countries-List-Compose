package com.example.countryinfo.presentation

import com.example.countryinfo.domain.model.DetailedCountry
import com.example.countryinfo.domain.model.SimpleCountry

data class CountryState(
    var countryList: List<SimpleCountry> = emptyList(),
    var isLoading: Boolean = false,
    var selectedCountry: DetailedCountry? = null
)