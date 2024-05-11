package com.example.countryinfo.domain.usecase

import com.example.countryinfo.domain.CountryClient
import com.example.countryinfo.domain.model.SimpleCountry

class GetCountryUseCase(
    private val countryClient: CountryClient
) {

    suspend fun getCountry(): List<SimpleCountry> {
        return countryClient.getCountry().sortedBy { it.name }
    }
}