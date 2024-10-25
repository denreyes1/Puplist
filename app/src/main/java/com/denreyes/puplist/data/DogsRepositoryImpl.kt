package com.denreyes.puplist.data

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody

class DogsRepositoryImpl(
    private val dogsAPI: DogsAPI,
    private val dispatcher: CoroutineDispatcher
): DogsRepository {

    override suspend fun getDogs(): NetworkResult<List<Dog>> {
        return withContext(dispatcher) {
            try {
                val response = dogsAPI.fetchDog()
                if(response.isSuccessful) {
                    NetworkResult.Success(response.body()!!)
                } else {
                    NetworkResult.Error(response.errorBody().toString())
                }
            } catch (e: Exception) {
                NetworkResult.Error(e.message ?: "Unknown error")
            }
        }
    }

}