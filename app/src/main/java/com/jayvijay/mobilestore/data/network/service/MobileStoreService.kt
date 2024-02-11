package com.jayvijay.mobilestore.data.network.service

import com.jayvijay.mobilestore.data.dto.OrderListDto
import retrofit2.http.GET

fun interface MobileStoreService {
    @GET("response.json")
    suspend fun getOrders(): Result<OrderListDto>
}