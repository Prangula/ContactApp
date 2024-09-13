package com.myapplication.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.Date
@Parcelize
data class ContactUi(
    val name: String = "",
    val number: String = "",
    val date: Date = Date(),
    val id: Int? = null
):Parcelable