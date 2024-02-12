package com.jayvijay.mobilestore.data.dto

import org.junit.Assert.*
import org.junit.Test

class ItemDtoTest {
    @Test
    fun should_convert_item_dto_to_item_entity_with_correct_values() {
        // Given
        val itemDto = ItemDto(1, "Item 1", 100)

        // When
        val result = itemDto.toItemEntity()

        // Then
        assertEquals(1, result.id)
        assertEquals("Item 1", result.name)
        assertEquals(100, result.price)
    }
}