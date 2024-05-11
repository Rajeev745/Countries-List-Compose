package com.example.countryinfo.domain.model

import java.util.Currency

data class SimpleCountry(
    val name: String,
    val emoji: String,
    val capital: String,
    val currency: String,
    val code: String
)