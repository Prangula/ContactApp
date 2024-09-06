package com.myapplication.di.useCaseModule

import com.myapplication.domain.usecase.contactsUseCase.useCase.ContactsUseCase
import com.myapplication.domain.usecase.contactsUseCase.useCaseImpl.ContactsUseCaseImpl
import com.myapplication.domain.usecase.deleteUseCase.useCase.DeleteUseCase
import com.myapplication.domain.usecase.deleteUseCase.useCaseImpl.DeleteUseCaseImpl
import com.myapplication.domain.usecase.insertUseCase.InsertUseCase
import com.myapplication.domain.usecase.insertUseCase.InsertUseCaseImpl
import com.myapplication.domain.usecase.updateUseCase.useCase.UpdateUseCase
import com.myapplication.domain.usecase.updateUseCase.useCaseImpl.UpdateUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    single<InsertUseCase> { InsertUseCaseImpl(get()) }
    single<UpdateUseCase> { UpdateUseCaseImpl(get()) }
    single<DeleteUseCase> { DeleteUseCaseImpl(get()) }
    single<ContactsUseCase> { ContactsUseCaseImpl(get()) }
}