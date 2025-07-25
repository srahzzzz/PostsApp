package com.example.postsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.postsapp.data.ApiService

object RetrofitClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
//this git push is to confirm everything completed