package com.jayvijay.mobilestore.data.di

import com.jayvijay.mobilestore.data.repository.OrderRepositoryImpl
import com.jayvijay.mobilestore.domain.repository.OrderRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<OrderRepository> { OrderRepositoryImpl(get()) }
}