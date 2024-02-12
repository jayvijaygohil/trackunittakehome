package com.jayvijay.mobilestore.data.di

import com.jayvijay.mobilestore.data.network.client.RetrofitHelper
import com.jayvijay.mobilestore.data.network.service.MobileStoreService
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single { RetrofitHelper.provideRetrofit(get()) }
    factory { get<Retrofit>().create(MobileStoreService::class.java) }
}