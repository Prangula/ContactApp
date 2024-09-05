package com.myapplication.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.myapplication.data.local.dao.ContactDao
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.data.local.typeconverter.DateConverter

@Database(
    entities = [ContactEntity::class],
    version = 10
)
@TypeConverters(DateConverter::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}