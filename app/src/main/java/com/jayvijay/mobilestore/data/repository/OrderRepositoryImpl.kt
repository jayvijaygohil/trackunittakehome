package com.jayvijay.mobilestore.data.repository

import com.jayvijay.mobilestore.data.network.service.MobileStoreService
import com.jayvijay.mobilestore.domain.entity.OrderEntity
import com.jayvijay.mobilestore.domain.entity.toOrderEntityList
import com.jayvijay.mobilestore.domain.repository.OrderRepository

class OrderRepositoryImpl(
    private val mobileStoreService: MobileStoreService
) : OrderRepository {
    override suspend fun fetchOrders(): Result<List<OrderEntity>> {
        return mobileStoreService.getOrders()
            .map { orderDtoList ->
                orderDtoList.toOrderEntityList()
            }
    }
}