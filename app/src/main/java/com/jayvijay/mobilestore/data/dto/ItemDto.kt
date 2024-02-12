package com.jayvijay.mobilestore.data.dto

import com.jayvijay.mobilestore.domain.entity.ItemEntity
import kotlinx.serialization.Serializable

@Serializable
data class ItemDto(
    val id: Int,
    val name: String,
    val price: Int
)

fun ItemDto.toItemEntity() = ItemEntity(
    id,
    name,
    price
)