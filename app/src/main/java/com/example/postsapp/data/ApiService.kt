package com.example.postsapp.data


import com.example.postsapp.model.Message
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getMessages(): List<Message>
}
