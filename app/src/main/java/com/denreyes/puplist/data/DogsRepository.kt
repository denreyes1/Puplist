package com.denreyes.puplist.data

interface DogsRepository {
    suspend fun getDogs(): NetworkResult<List<Dog>>
}