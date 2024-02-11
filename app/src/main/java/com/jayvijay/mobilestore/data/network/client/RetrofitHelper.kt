package com.jayvijay.mobilestore.data.network.client

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import com.jayvijay.mobilestore.common.CoroutineDispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import timber.log.Timber

@OptIn(ExperimentalSerializationApi::class)
object RetrofitHelper {
    private const val BASE_URL = "https://raw.githubusercontent.com/jayvijaygohil/trackunittakehome/main/"

    fun provideRetrofit(coroutineDispatcherProvider: CoroutineDispatcherProvider): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(provideOkHttpClient())
        .addConverterFactory(getJson().asConverterFactory("application/json".toMediaType()))
        .addCallAdapterFactory(ResultCallAdapterFactory.create(CoroutineScope(coroutineDispatcherProvider.io)))
        .build()

    private fun getJson() = Json {
        explicitNulls = false
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = true
    }

    private fun provideOkHttpClient() = OkHttpClient.Builder().apply {
        if (BuildConfig.DEBUG) {
            addInterceptor(provideOkHttpLoggingInterceptor())
        }
    }.build()

    private fun provideOkHttpLoggingInterceptor() = HttpLoggingInterceptor { message: String ->
        Timber.d(message)
    }.apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}