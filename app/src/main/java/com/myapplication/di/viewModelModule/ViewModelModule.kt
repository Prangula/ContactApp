package com.myapplication.di.viewModelModule

import com.myapplication.presentation.screen.contactsScreen.vm.ContactsViewModel
import com.myapplication.presentation.screen.deleteVm.DeleteViewModel
import com.myapplication.presentation.screen.insertScreen.vm.InsertViewModel
import com.myapplication.presentation.screen.updateScreen.vm.UpdateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ContactsViewModel(get()) }
    viewModel { InsertViewModel(get()) }
    viewModel { UpdateViewModel(get()) }
    viewModel { DeleteViewModel(get()) }
}