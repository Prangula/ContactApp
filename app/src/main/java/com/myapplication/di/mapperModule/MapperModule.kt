package com.myapplication.di.mapperModule

import com.myapplication.data.local.localMapper.ContactDomainMapper
import com.myapplication.domain.domainMapper.ContactUiMapper
import org.koin.dsl.module

val mapperModule = module {
    single { ContactDomainMapper() }
    single { ContactUiMapper() }
}