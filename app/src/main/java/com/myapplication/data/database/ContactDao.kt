package com.myapplication.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contactItem: ContactItem)

    @Update
    suspend fun update(contactItem: ContactItem)

    @Delete
    suspend fun delete(contactItem: ContactItem)

    @Query("SELECT * FROM contact_table ORDER BY date DESC")
    fun getAllContacts(): Flow<List<ContactItem>>
}