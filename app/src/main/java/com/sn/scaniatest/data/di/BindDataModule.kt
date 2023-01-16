package de.artificient.data.di

import com.sn.scaniatest.data.repository.CountriesListRepository
import com.sn.scaniatest.data.repository.CountryDetailRepository
import com.sn.scaniatest.domain.repository.ICountriesListRepository
import com.sn.scaniatest.domain.repository.ICountryDetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindDataModule {

    @Binds
    @Singleton
    abstract fun bindCountriesListRepository(countriesListRepository: CountriesListRepository): ICountriesListRepository

    @Binds
    @Singleton
    abstract fun bindCountryDetailRepository(countryDetailRepository: CountryDetailRepository): ICountryDetailRepository

}