package com.jayvijay.mobilestore.common.di

import com.jayvijay.mobilestore.common.CoroutineDispatcherProvider
import com.jayvijay.mobilestore.common.CoroutineDispatcherProviderImpl
import org.koin.dsl.module

val commonModule = module {
    single<CoroutineDispatcherProvider> { CoroutineDispatcherProviderImpl() }
}