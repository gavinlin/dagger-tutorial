package com.gavincode.tutorial.di

import com.gavincode.tutorial.CommandRouter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    LoginCommandModule::class,
    HelloWorldModule::class,
    SystemOutModule::class,
    UserCommandsModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}