package com.jayvijay.mobilestore.data.dto

import com.jayvijay.mobilestore.domain.entity.OrderEntity
import kotlinx.serialization.Serializable

@Serializable
data class OrderDto(
    val orderId: Int,
    val customerId: Int,
    val totalPrice: Int,
    val items: List<ItemDto>
)

fun OrderDto.toOrderEntity() = OrderEntity(
    orderId,
    customerId,
    totalPrice,
    items.map { it.toItemEntity() }
)