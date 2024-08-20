package com.myapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "contact_table")
data class ContactItem(
    val name: String = "",
    val number: String = "",
    val date: Date = Date(),
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
