package com.jayvijay.mobilestore.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface CoroutineDispatcherProvider {
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
    val immediate: CoroutineDispatcher
}

class CoroutineDispatcherProviderImpl(
    override val main: CoroutineDispatcher = Dispatchers.Main,
    override val default: CoroutineDispatcher = Dispatchers.Default,
    override val io: CoroutineDispatcher = Dispatchers.IO,
    override val immediate: CoroutineDispatcher = Dispatchers.Main.immediate
) : CoroutineDispatcherProvider