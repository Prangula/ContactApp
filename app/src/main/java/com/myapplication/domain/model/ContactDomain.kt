package com.myapplication.domain.model

import java.util.Date

data class ContactDomain(
    val name: String = "",
    val number: String = "",
    val date: Date = Date(),
    val id: Int? = null
)
