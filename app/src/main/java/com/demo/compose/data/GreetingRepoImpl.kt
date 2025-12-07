package com.demo.compose.data

import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GreetingRepoImpl @Inject constructor() : GreetingRepository {
    override suspend fun greeting(name: String): String {
        delay(300) // Simulate network/database
        return "Hello, $name!"
    }
}