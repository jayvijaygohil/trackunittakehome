package com.jayvijay.mobilestore.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderEntity(
    val orderId: Int,
    val customerId: Int,
    val totalPrice: Int,
    val items: List<ItemEntity>
) : Parcelable