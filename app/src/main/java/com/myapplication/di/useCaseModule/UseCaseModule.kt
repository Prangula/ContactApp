package com.myapplication.di.useCaseModule
import com.myapplication.domain.usecase.contactsUseCase.ContactsUseCase
import com.myapplication.domain.usecase.contactsUseCase.ContactsUseCaseImpl
import com.myapplication.domain.usecase.deleteUseCase.DeleteUseCase
import com.myapplication.domain.usecase.insertUseCase.InsertUseCase
import com.myapplication.domain.usecase.updateUseCase.UpdateUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<InsertUseCase> { InsertUseCase(get()) }
    single<UpdateUseCase> { UpdateUseCase(get()) }
    single<DeleteUseCase> { DeleteUseCase(get()) }
    single<ContactsUseCase> { ContactsUseCaseImpl(get()) }
}