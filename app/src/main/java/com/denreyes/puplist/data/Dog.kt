package com.denreyes.puplist.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    @SerialName("id")
    val id: String,
    @SerialName("url")
    val image: String
)