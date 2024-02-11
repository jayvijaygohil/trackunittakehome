package com.jayvijay.mobilestore.ui.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jayvijay.mobilestore.common.CoroutineDispatcherProvider
import com.jayvijay.mobilestore.domain.usecase.FetchOrdersUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class OrdersViewModel(
    private val dispatchProvider: CoroutineDispatcherProvider,
    private val useCase: FetchOrdersUseCase
) : ContainerHost<OrderState, OrderSideEffect>, ViewModel() {
    override val container: Container<OrderState, OrderSideEffect> =
        container(OrderState(status = OrderStatus.Loading))

    fun loadOrders() = intent {
        reduce { state.copy(status = OrderStatus.Loading) }
        viewModelScope.launch(dispatchProvider.immediate) {
            withContext(dispatchProvider.io) {
                useCase.invoke()
                    .onSuccess { orderEntityList ->
                        if (orderEntityList.isEmpty()) {
                            reduce { state.copy(status = OrderStatus.Empty) }
                            this@intent.postSideEffect(OrderSideEffect.RetryToast)
                        } else {
                            reduce { state.copy(status = OrderStatus.Success(orderEntityList.map { it.toOrder() })) }
                        }
                    }
                    .onFailure {
                        reduce { state.copy(status = OrderStatus.Empty) }
                        this@intent.postSideEffect(OrderSideEffect.RetryToast)
                    }
            }
        }
    }
}