package com.denreyes.puplist.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    val id: String,
    val url: String,
    val breeds: List<Breed>
)

@Serializable
data class Breed(
    val name: String,
    val temperament: String
)