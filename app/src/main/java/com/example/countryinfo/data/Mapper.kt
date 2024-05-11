package com.example.countryinfo.data

import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.countryinfo.domain.model.DetailedCountry
import com.example.countryinfo.domain.model.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        name = name,
        capital = capital ?: "no capital",
        emoji = emoji,
        code = code,
        currency = currency ?: "no currency",
        states = states.mapNotNull { it.name },
        language = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        name = name,
        emoji = emoji,
        capital = capital ?: "no capital",
        currency = currency ?: "no currency",
        code = code
    )
}