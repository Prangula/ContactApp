package com.myapplication

import android.app.Application
import com.myapplication.di.databaseModule.databaseModule
import com.myapplication.di.mapperModule.mapperModule
import com.myapplication.di.repositoryModule.repositoryModule
import com.myapplication.di.useCaseModule.useCaseModule
import com.myapplication.di.viewModelModule.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ContactApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ContactApp)
            modules(databaseModule, repositoryModule, useCaseModule, viewModelModule, mapperModule)
        }
    }
}