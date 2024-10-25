package com.denreyes.puplist.data

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface DogsAPI {
    @GET("images/search?limit=10&has_breeds=true")
    suspend fun fetchDog(@Header("x-api-key") apiKey: String): Response<List<Dog>>

    @GET("images/search?limit=10&has_breeds=true")
    suspend fun fetchDogGeneric(): Response<ResponseBody>
}