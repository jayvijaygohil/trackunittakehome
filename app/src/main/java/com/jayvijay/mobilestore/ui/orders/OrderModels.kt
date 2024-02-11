package com.jayvijay.mobilestore.ui.orders

import android.os.Parcelable
import com.jayvijay.mobilestore.domain.entity.ItemEntity
import com.jayvijay.mobilestore.domain.entity.OrderEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Order(
    val orderId: String,
    val customerId: Int,
    val totalPrice: Int,
    val items: List<Item>
) : Parcelable

@Parcelize
data class Item(
    val id: Int,
    val name: String,
    val price: Int
) : Parcelable

@Parcelize
sealed class OrderStatus : Parcelable {
    @Parcelize
    data object Loading : OrderStatus()

    @Parcelize
    data object Empty : OrderStatus()

    @Parcelize
    data class Success(val data: List<Order>) : OrderStatus()
}

@Parcelize
data class OrderState(
    val status: OrderStatus
) : Parcelable

@Parcelize
sealed class OrderSideEffect : Parcelable {
    @Parcelize
    data object RetryToast : OrderSideEffect()
}

fun OrderEntity.toOrder(): Order =
    Order(
        orderId.toString(),
        customerId,
        totalPrice,
        items.map { itemEntity ->
            Item(
                itemEntity.id,
                itemEntity.name,
                itemEntity.price
            )
        }
    )