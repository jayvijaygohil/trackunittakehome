package com.jayvijay.mobilestore.domain.repository

import com.jayvijay.mobilestore.domain.entity.OrderEntity

fun interface OrderRepository {
    suspend fun fetchOrders(): Result<List<OrderEntity>>
}