package com.jayvijay.mobilestore.data.repository

import com.jayvijay.mobilestore.data.dto.ItemDto
import com.jayvijay.mobilestore.data.dto.OrderDto
import com.jayvijay.mobilestore.data.dto.OrderListDto
import com.jayvijay.mobilestore.data.network.service.MobileStoreService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class OrderRepositoryImplTest {
    @Test
    fun shouldFetchOrdersAndMapToOrderEntityList() {
        // Given
        val orderDtoList = OrderListDto(listOf(OrderDto(1, 1, 100, listOf(ItemDto(1, "item1", 10)))))
        val mobileStoreService = mockk<MobileStoreService>()
        coEvery { mobileStoreService.getOrders() } returns Result.success(orderDtoList)
        val orderRepository = OrderRepositoryImpl(mobileStoreService)

        // When
        val result = runBlocking { orderRepository.fetchOrders() }

        // Then
        result.isSuccess
        assertTrue(result.isSuccess)
        val orderEntityList = result.getOrThrow()
        assertEquals(1, orderEntityList.size)
        assertEquals(1, orderEntityList[0].orderId)
        assertEquals(1, orderEntityList[0].customerId)
        assertEquals(100, orderEntityList[0].totalPrice)
        assertEquals(1, orderEntityList[0].items.size)
        assertEquals("item1", orderEntityList[0].items[0].name)
        assertEquals(10, orderEntityList[0].items[0].price)
    }

    @Test
    fun shouldReturnResultSuccessWithOrderEntityList() {
        // Given
        val orderDtoList = OrderListDto(listOf(OrderDto(1, 1, 100, listOf(ItemDto(1, "item1", 10)))))
        val mobileStoreService = mockk<MobileStoreService>()
        coEvery { mobileStoreService.getOrders() } returns Result.success(orderDtoList)
        val orderRepository = OrderRepositoryImpl(mobileStoreService)

        // When
        val result = runBlocking { orderRepository.fetchOrders() }

        // Then
        assertTrue(result.isSuccess)
        val orderEntityList = result.getOrThrow()
        assertEquals(1, orderEntityList.size)
        assertEquals(1, orderEntityList[0].orderId)
        assertEquals(1, orderEntityList[0].customerId)
        assertEquals(100, orderEntityList[0].totalPrice)
        assertEquals(1, orderEntityList[0].items.size)
        assertEquals("item1", orderEntityList[0].items[0].name)
        assertEquals(10, orderEntityList[0].items[0].price)
    }

    @Test
    fun shouldReturnEmptyListWhenMobileStoreServiceReturnsEmptyOrderList() {
        // Given
        val orderDtoList = OrderListDto(emptyList())
        val mobileStoreService = mockk<MobileStoreService>()
        coEvery { mobileStoreService.getOrders() } returns Result.success(orderDtoList)
        val orderRepository = OrderRepositoryImpl(mobileStoreService)

        // When
        val result = runBlocking { orderRepository.fetchOrders() }

        // Then
        assertTrue(result.isSuccess)
        val orderEntityList = result.getOrThrow()
        assertTrue(orderEntityList.isEmpty())
    }
}