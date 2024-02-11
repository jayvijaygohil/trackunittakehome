package com.jayvijay.mobilestore

import android.app.Application
import com.google.android.material.color.DynamicColors
import com.jayvijay.mobilestore.common.di.commonModule
import com.jayvijay.mobilestore.data.di.networkModule
import com.jayvijay.mobilestore.data.di.repositoryModule
import com.jayvijay.mobilestore.domain.di.useCaseModule
import com.jayvijay.mobilestore.ui.di.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MobileStoreApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        enableDynamicColors()
        initKoin()
        initTimber()
    }

    private fun enableDynamicColors() {
        DynamicColors.applyToActivitiesIfAvailable(this)
    }

    private fun initKoin() {
        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.DEBUG
                } else {
                    Level.INFO
                }
            )
            androidContext(this@MobileStoreApplication)
            modules(listOf(
                commonModule,
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            ))
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}