package com.jayvijay.mobilestore.domain.entity

import android.os.Parcelable
import com.jayvijay.mobilestore.data.dto.ItemDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemEntity(
    val id: Int,
    val name: String,
    val price: Int
): Parcelable

fun ItemDto.toItemEntity() = ItemEntity(
    id,
    name,
    price
)
