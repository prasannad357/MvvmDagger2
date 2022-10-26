package com.practice.mvvmdagger2.di

import com.practice.mvvmdagger2.api.QuoteApi
import com.practice.mvvmdagger2.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).build()
    }

    @Singleton
    @Provides
    fun getQuoteApi(retrofit: Retrofit):QuoteApi{
        return retrofit.create(QuoteApi::class.java)
    }
}