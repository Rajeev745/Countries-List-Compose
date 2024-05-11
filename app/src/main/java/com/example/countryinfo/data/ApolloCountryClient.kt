package com.example.countryinfo.data

import com.apollographql.apollo3.ApolloClient
import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.countryinfo.domain.CountryClient
import com.example.countryinfo.domain.model.DetailedCountry
import com.example.countryinfo.domain.model.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountry(): List<SimpleCountry> {
        return apolloClient.query(CountriesQuery())
            .execute().data?.countries?.map { it.toSimpleCountry() } ?: emptyList()

    }

    override suspend fun getCountryDetail(code: String): DetailedCountry? {
        return apolloClient.query(CountryQuery(code)).execute().data?.country?.toDetailedCountry()
    }
}