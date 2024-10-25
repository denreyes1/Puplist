package com.denreyes.puplist.views

import com.denreyes.puplist.data.Dog

data class DogsUIState(
    val isLoading: Boolean = false,
    val dogs: List<Dog> = emptyList(),
    val error: String? = null
)