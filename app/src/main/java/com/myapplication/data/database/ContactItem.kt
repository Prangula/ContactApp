package com.myapplication.data.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.Date

@Entity(tableName = "contact_table")
@Parcelize
data class ContactItem(
    val name: String = "",
    val number: String = "",
    val date: Date = Date(),
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
) : Parcelable
