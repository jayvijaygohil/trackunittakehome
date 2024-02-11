package com.jayvijay.mobilestore.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ItemDto(
    val id: Int,
    val name: String,
    val price: Int
)