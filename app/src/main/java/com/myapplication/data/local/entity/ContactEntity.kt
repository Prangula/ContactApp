package com.myapplication.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.Date

@Entity(tableName = "contact_table")
data class ContactEntity(
    val name: String = "",
    val number: String = "",
    val date: Date = Date(),
    @PrimaryKey
    val id: Int? = null
)