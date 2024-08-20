package com.myapplication.data.database.typeconverter

import androidx.room.RenameTable
import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    fun toDate(date: Long): Date {
        return Date(date)
    }
}