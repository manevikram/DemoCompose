package com.demo.compose.domain

import com.demo.compose.data.GreetingRepository
import javax.inject.Inject

class GreetingUseCase @Inject constructor(
    private val repository: GreetingRepository
) {
    suspend operator fun invoke(name : String) : String {
        return repository.greeting(name)
    }
}