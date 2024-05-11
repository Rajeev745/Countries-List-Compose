package com.example.countryinfo.domain.usecase

import com.example.countryinfo.domain.CountryClient
import com.example.countryinfo.domain.model.DetailedCountry

class GetCountryDetailUseCase(
    private val countryClient: CountryClient
) {

    suspend fun getCountryDetail(code: String): DetailedCountry? {
        return countryClient.getCountryDetail(code)
    }
}