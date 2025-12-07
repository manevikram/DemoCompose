package com.demo.compose.di

import com.demo.compose.data.GreetingRepoImpl
import com.demo.compose.data.GreetingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DemoComposeAppModule {

    @Provides
    @Singleton
    fun providesGreetingRepository(): GreetingRepository = GreetingRepoImpl()
}