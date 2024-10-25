package com.denreyes.puplist.data

interface PetsRepository {
    suspend fun getDogs(): NetworkResult<List<Dog>>
}