package com.demo.compose.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.compose.domain.GreetingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GreetingViewModel @Inject constructor(
    private val greetingUseCase: GreetingUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState

    fun loadGreeting(name: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val greeting = greetingUseCase(name)
                _uiState.value = UiState.Success(greeting)
            } catch (t: Throwable) {
                _uiState.value = UiState.Error(t.message ?: "Unknown error")
            }
        }
    }
}

sealed class UiState {
    object Idle : UiState()
    object Loading : UiState()
    data class Success(val text: String) : UiState()
    data class Error(val message: String) : UiState()
}