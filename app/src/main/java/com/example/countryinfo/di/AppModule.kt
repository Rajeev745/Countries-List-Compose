package com.example.countryinfo.di

import com.apollographql.apollo3.ApolloClient
import com.example.countryinfo.data.ApolloCountryClient
import com.example.countryinfo.domain.CountryClient
import com.example.countryinfo.domain.usecase.GetCountryDetailUseCase
import com.example.countryinfo.domain.usecase.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient {
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun providesCountryDetailUseCase(countryClient: CountryClient): GetCountryDetailUseCase {
        return GetCountryDetailUseCase(countryClient)
    }

    @Provides
    @Singleton
    fun providesCountryUseCase(countryClient: CountryClient): GetCountryUseCase {
        return GetCountryUseCase(countryClient)
    }
}