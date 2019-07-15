package com.gavincode.tutorial.di

import com.gavincode.tutorial.CommandRouter
import dagger.Component

@Component(modules = [
    HelloWorldModule::class,
    SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}