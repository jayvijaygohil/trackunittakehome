package com.jayvijay.mobilestore.domain.entity

import android.os.Parcelable
import com.jayvijay.mobilestore.data.dto.OrderDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderEntity(
    val orderId: Int,
    val customerId: Int,
    val totalPrice: Int,
    val items: List<ItemEntity>
): Parcelable

fun OrderDto.toOrderEntity() = OrderEntity(
    orderId,
    customerId,
    totalPrice,
    items.map { it.toItemEntity() }
)

fun List<OrderDto>.toOrderEntityList() = this.map { it.toOrderEntity() }