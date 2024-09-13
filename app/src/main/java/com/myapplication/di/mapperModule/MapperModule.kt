package com.myapplication.di.mapperModule

import com.myapplication.data.local.mapper.ContactDomainToEntityMapper
import com.myapplication.data.local.mapper.ContactEntityToDomainMapper
import com.myapplication.presentation.mapper.ContactDomainToUiMapper
import com.myapplication.presentation.mapper.ContactUiToDomainMapper
import org.koin.dsl.module

val mapperModule = module {
    single { ContactEntityToDomainMapper() }
    single { ContactDomainToUiMapper() }
    single { ContactDomainToEntityMapper() }
    single { ContactUiToDomainMapper() }
}