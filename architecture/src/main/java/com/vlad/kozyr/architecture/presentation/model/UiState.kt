package com.vlad.kozyr.architecture.presentation.model

sealed class UiState {
    object Loading : UiState()
    object Completed: UiState()
    data class Error(val message: String): UiState()
}