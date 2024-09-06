package com.myapplication.di.repositoryModule

import com.myapplication.data.repository.ContactRepositoryImpl
import com.myapplication.domain.repository.ContactRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<ContactRepository> { ContactRepositoryImpl(get()) }

}