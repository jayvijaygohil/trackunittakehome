package com.jayvijay.mobilestore.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class OrderDto(
    val orderId: Int,
    val customerId: Int,
    val totalPrice: Int,
    val items: List<ItemDto>
)