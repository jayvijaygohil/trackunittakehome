package com.jayvijay.mobilestore.data.dto

import com.jayvijay.mobilestore.domain.entity.OrderEntity
import org.junit.Assert.*
import org.junit.Test

class OrderListDtoTest {
    @Test
    fun should_return_empty_list_when_input_orderlistdto_has_empty_orders_list() {
        // Given
        val orderListDto = OrderListDto(emptyList())

        // When
        val result = orderListDto.toOrderEntityList()

        // Then
        assertEquals(emptyList<OrderEntity>(), result)
    }

    @Test
    fun should_return_list_with_same_size_as_input_orderlistdto_orders_list() {
        // Given
        val orderDto1 = OrderDto(1, 255, 10, emptyList())
        val orderDto2 = OrderDto(2, 266, 20, emptyList())
        val orderListDto = OrderListDto(listOf(orderDto1, orderDto2))

        // When
        val result = orderListDto.toOrderEntityList()

        // Then
        assertEquals(2, result.size)
    }

    @Test
    fun should_return_list_with_same_properties_as_input_orderlistdto_orders_list() {
        // Given
        val itemDto1 = ItemDto(1, "item1", 5)
        val itemDto2 = ItemDto(2, "item2", 10)
        val orderDto1 = OrderDto(1, 1, 10, listOf(itemDto1))
        val orderDto2 = OrderDto(2, 2, 20, listOf(itemDto2))
        val orderListDto = OrderListDto(listOf(orderDto1, orderDto2))

        // When
        val result = orderListDto.toOrderEntityList()

        // Then
        assertEquals(1, result[0].orderId)
        assertEquals(1, result[0].customerId)
        assertEquals(10, result[0].totalPrice)
        assertEquals(1, result[0].items.size)
        assertEquals("item1", result[0].items[0].name)
        assertEquals(5, result[0].items[0].price)

        assertEquals(2, result[1].orderId)
        assertEquals(2, result[1].customerId)
        assertEquals(20, result[1].totalPrice)
        assertEquals(1, result[1].items.size)
        assertEquals("item2", result[1].items[0].name)
        assertEquals(10, result[1].items[0].price)
    }
}