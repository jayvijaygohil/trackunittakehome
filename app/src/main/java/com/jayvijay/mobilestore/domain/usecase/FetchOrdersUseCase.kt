package com.jayvijay.mobilestore.domain.usecase

import com.jayvijay.mobilestore.domain.entity.OrderEntity
import com.jayvijay.mobilestore.domain.repository.OrderRepository

fun interface FetchOrdersUseCase {
    suspend fun invoke(): Result<List<OrderEntity>>
}

class FetchOrdersUseCaseImpl(
    private val repository: OrderRepository
): FetchOrdersUseCase {
    override suspend fun invoke(): Result<List<OrderEntity>> {
        return repository.fetchOrders()
    }
}