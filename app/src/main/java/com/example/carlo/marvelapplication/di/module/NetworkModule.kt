package com.example.carlo.marvelapplication.di.module

import com.example.carlo.marvelapplication.service.network.MarvelService
import com.example.carlo.marvelapplication.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Module which provides all required dependencies about network.
 */
@Module
@Suppress("unused")
object NetworkModule {

    /**
     * Provides the Marvel service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Marvel service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun providesMarvelApi(retrofit: Retrofit): MarvelService {
        return retrofit.create(MarvelService::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

}