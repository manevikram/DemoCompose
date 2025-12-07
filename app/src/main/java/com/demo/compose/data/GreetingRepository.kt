package com.demo.compose.data

interface GreetingRepository {
    suspend fun greeting(name: String): String
}