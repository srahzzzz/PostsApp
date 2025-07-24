package com.example.postsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsapp.model.Message
import com.example.postsapp.repository.MessageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MessageRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Message>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Message>>> = _uiState

    init {
        fetchMessages()
    }

    fun fetchMessages() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val result = repository.fetchMessages()
            _uiState.value = result.fold(
                onSuccess = { UiState.Success(it) },
                onFailure = { UiState.Error(it.message ?: "Unknown error") }
            )
        }
    }
}
