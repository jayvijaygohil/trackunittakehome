package com.jayvijay.mobilestore.domain.di

import com.jayvijay.mobilestore.domain.usecase.FetchOrdersUseCase
import com.jayvijay.mobilestore.domain.usecase.FetchOrdersUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<FetchOrdersUseCase> { FetchOrdersUseCaseImpl(get()) }
}