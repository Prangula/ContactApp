package com.myapplication.di.databaseModule

import android.content.Context
import androidx.room.Room
import com.myapplication.data.local.dao.ContactDao
import com.myapplication.data.local.database.ContactDatabase
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get<Context>(),
            ContactDatabase::class.java,
            "contact_database"
        ).build()
    }

    single<ContactDao> { get<ContactDatabase>().contactDao() }
}