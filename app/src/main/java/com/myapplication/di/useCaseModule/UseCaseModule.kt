package com.myapplication.di.useCaseModule

import com.myapplication.domain.usecase.contactsUseCase.ContactsUseCase
import com.myapplication.domain.usecase.contactsUseCase.ContactsUseCaseImpl
import com.myapplication.domain.usecase.deleteUseCase.DeleteUseCase
import com.myapplication.domain.usecase.deleteUseCase.DeleteUseCaseImpl
import com.myapplication.domain.usecase.insertUseCase.InsertUseCase
import com.myapplication.domain.usecase.insertUseCase.InsertUseCaseImpl
import com.myapplication.domain.usecase.updateUseCase.UpdateUseCase
import com.myapplication.domain.usecase.updateUseCase.UpdateUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<InsertUseCase> { InsertUseCaseImpl(get()) }
    single<UpdateUseCase> { UpdateUseCaseImpl(get()) }
    single<DeleteUseCase> { DeleteUseCaseImpl(get()) }
    single<ContactsUseCase> { ContactsUseCaseImpl(get()) }
}