package com.example.catsapi.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
object CatService {

    private var interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()

    init {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    }

    val ENDPOINT = "https://cat-fact.herokuapp.com"

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl(ENDPOINT)
        .client(client)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val catAPI = retrofit.create(CatApi::class.java)
}

