package com.example.countryinfo.domain

import com.example.countryinfo.domain.model.DetailedCountry
import com.example.countryinfo.domain.model.SimpleCountry

interface CountryClient {

    suspend fun getCountry(): List<SimpleCountry>

    suspend fun getCountryDetail(code: String): DetailedCountry?
}