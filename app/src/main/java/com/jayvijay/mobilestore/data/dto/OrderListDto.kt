package com.jayvijay.mobilestore.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class OrderListDto(
    val orders: List<OrderDto>
)