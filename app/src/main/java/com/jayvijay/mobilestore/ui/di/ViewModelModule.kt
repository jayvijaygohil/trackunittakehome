package com.jayvijay.mobilestore.ui.di

import com.jayvijay.mobilestore.ui.orders.OrdersViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::OrdersViewModel)
}