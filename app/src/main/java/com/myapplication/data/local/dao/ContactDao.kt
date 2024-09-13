package com.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.myapplication.data.local.entity.ContactEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contactItem: ContactEntity)

    @Update
    suspend fun update(contactItem: ContactEntity)

    @Delete
    suspend fun delete(contactItem: ContactEntity)

    @Query("SELECT * FROM contact_table ORDER BY date DESC")
    fun getAllContacts(): Flow<List<ContactEntity>>
}