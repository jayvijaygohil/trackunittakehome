package com.jayvijay.mobilestore.data.dto

import org.junit.Assert.*
import org.junit.Test

class OrderDtoTest {
    @Test
    fun should_map_order_dto_to_order_entity_successfully() {
        // Given
        val orderDto = OrderDto(
            orderId = 1,
            customerId = 2,
            totalPrice = 100,
            items = listOf(
                ItemDto(id = 1, name = "Item 1", price = 10),
                ItemDto(id = 2, name = "Item 2", price = 20)
            )
        )

        // When
        val result = orderDto.toOrderEntity()

        // Then
        assertEquals(orderDto.orderId, result.orderId)
        assertEquals(orderDto.customerId, result.customerId)
        assertEquals(orderDto.totalPrice, result.totalPrice)
        assertEquals(orderDto.items.size, result.items.size)
        for (i in orderDto.items.indices) {
            assertEquals(orderDto.items[i].id, result.items[i].id)
            assertEquals(orderDto.items[i].name, result.items[i].name)
            assertEquals(orderDto.items[i].price, result.items[i].price)
        }
    }
}