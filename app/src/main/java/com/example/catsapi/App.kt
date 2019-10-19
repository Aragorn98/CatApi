package com.example.catsapi

import android.app.Application
import com.example.coroutineproject.di.apiModule
import com.example.coroutineproject.di.dbModule
import com.example.coroutineproject.di.repoModule
import com.example.coroutineproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(listOf(dbModule, apiModule, repoModule, viewModelModule))
        }
    }
}