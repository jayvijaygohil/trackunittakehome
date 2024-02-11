package com.jayvijay.mobilestore.data.network.service

import com.jayvijay.mobilestore.data.dto.OrderDto
import retrofit2.http.GET

fun interface MobileStoreService {
    @GET("response.json")
    suspend fun getOrders(): Result<List<OrderDto>>
}