package com.myapplication.di.mapperModule

import com.myapplication.data.local.mapper.ContactMapper
import org.koin.dsl.module

val mapperModule = module {
    single { ContactMapper() }
}