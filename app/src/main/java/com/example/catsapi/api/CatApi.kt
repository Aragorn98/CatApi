package com.example.catsapi.api

import com.example.catsapi.models.All
import com.example.catsapi.models.Cat
import retrofit2.http.GET


interface CatApi {
    @GET("/facts")
    suspend fun getCats(): Cat
}