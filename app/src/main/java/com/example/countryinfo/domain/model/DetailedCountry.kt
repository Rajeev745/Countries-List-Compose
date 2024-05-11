package com.example.countryinfo.domain.model

import com.example.type.Continent

data class DetailedCountry(
    val name: String,
    val capital: String,
    val emoji: String,
    val code: String,
    val currency: String,
    val states: List<String>,
    val language: List<String>,
    val continent: String
)