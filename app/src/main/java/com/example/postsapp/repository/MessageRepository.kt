package com.example.postsapp.repository

import com.example.postsapp.data.ApiService
import com.example.postsapp.model.Message

class MessageRepository(private val api: ApiService) {

    suspend fun fetchMessages(): Result<List<Message>> {
        return try {
            val response = api.getMessages()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
