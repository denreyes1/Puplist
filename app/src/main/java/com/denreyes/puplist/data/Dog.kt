package com.denreyes.puplist.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    val id: String,
    val url: String
)