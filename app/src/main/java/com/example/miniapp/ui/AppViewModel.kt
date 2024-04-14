package com.example.miniapp.ui

import androidx.lifecycle.ViewModel
import com.example.miniapp.data.AppUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AppUIState())
    val uiState: StateFlow<AppUIState> = _uiState.asStateFlow()

    fun setEmail(email: String) {
        _uiState.update { currentState ->
            currentState.copy(
                email = email
            )
        }
    }

    fun setSubject(subject: String) {
        _uiState.update { currentState ->
            currentState.copy(
                subject = subject
            )
        }
    }

    fun setContent(content: String) {
        _uiState.update { currentState ->
            currentState.copy(
                content = content
            )
        }
    }

    fun resetOrder() {
        _uiState.value = AppUIState()
    }

}