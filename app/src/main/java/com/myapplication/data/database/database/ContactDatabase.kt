package com.myapplication.data.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.myapplication.data.database.dao.ContactDao
import com.myapplication.data.database.entity.ContactEntity
import com.myapplication.data.database.typeconverter.DateConverter

@Database(entities = [ContactEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {

        @Volatile
        private var instance: ContactDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, ContactDatabase::class.java,
                "contactDb.db"
            ).build()

    }

}
