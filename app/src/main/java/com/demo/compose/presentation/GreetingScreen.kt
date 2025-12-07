package com.demo.compose.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun GreetingScreen(
    modifier: Modifier = Modifier,
    viewModel: GreetingViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state) {
            is UiState.Idle -> Text("Press the button to load greeting")
            is UiState.Loading -> CircularProgressIndicator()
            is UiState.Success -> Text((state as UiState.Success).text)
            is UiState.Error -> Text("Error: ${(state as UiState.Error).message}")
        }

        Button(
            onClick = { viewModel.loadGreeting("Compose User") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Get Greeting")
        }
    }
}