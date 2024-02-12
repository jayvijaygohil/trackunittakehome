package com.jayvijay.mobilestore.domain.usecase

import com.jayvijay.mobilestore.domain.entity.OrderEntity
import com.jayvijay.mobilestore.domain.repository.OrderRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class FetchOrdersUseCaseImplTest {
    @Test
    fun `returns list of OrderEntity when repository returns successful Result`() {
        // Given
        val repository = mockk<OrderRepository>()
        val useCase = FetchOrdersUseCaseImpl(repository)
        val orderList = listOf(
            OrderEntity(1, 1, 100, emptyList()),
            OrderEntity(2, 2, 200, emptyList())
        )
        coEvery { repository.fetchOrders() } returns Result.success(orderList)

        // When
        val result = runBlocking { useCase.invoke() }

        // Then
        assertTrue(result.isSuccess)
        assertEquals(orderList, result.getOrThrow())
        coVerify { repository.fetchOrders() }
    }

    @Test
    fun `returns empty list when repository returns empty Result`() {
        // Given
        val repository = mockk<OrderRepository>()
        val useCase = FetchOrdersUseCaseImpl(repository)
        coEvery { repository.fetchOrders() } returns Result.success(emptyList())

        // When
        val result = runBlocking { useCase.invoke() }

        // Then
        assertTrue(result.isSuccess)
        assertTrue(result.getOrThrow().isEmpty())
        coVerify { repository.fetchOrders() }
    }

    @Test
    fun `returns failure Result when repository returns failure Result`() {
        // Given
        val repository = mockk<OrderRepository>()
        val useCase = FetchOrdersUseCaseImpl(repository)
        val error = Exception("Failed to fetch orders")
        coEvery { repository.fetchOrders() } returns Result.failure(error)

        // When
        val result = runBlocking { useCase.invoke() }

        // Then
        assertTrue(result.isFailure)
        assertEquals(error, result.exceptionOrNull())
        coVerify { repository.fetchOrders() }
    }

    @Test
    fun `returns failure Result when repository throws exception`() {
        // Given
        val repository = mockk<OrderRepository>()
        val useCase = FetchOrdersUseCaseImpl(repository)
        val exception = Exception("Failed to fetch orders")
        coEvery { repository.fetchOrders() } throws exception

        // When
        val result = runBlocking { useCase.invoke() }

        // Then
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
        coVerify { repository.fetchOrders() }
    }

    @Test
    fun `can handle OrderEntity with empty items list returned by repository`() {
        // Given
        val repository = mockk<OrderRepository>()
        val useCase = FetchOrdersUseCaseImpl(repository)
        val orderList = listOf(
            OrderEntity(1, 1, 100, emptyList()),
            OrderEntity(2, 2, 200, emptyList())
        )
        coEvery { repository.fetchOrders() } returns Result.success(orderList)

        // When
        val result = runBlocking { useCase.invoke() }

        // Then
        assertTrue(result.isSuccess)
        assertEquals(orderList, result.getOrThrow())
        coVerify { repository.fetchOrders() }
    }
}