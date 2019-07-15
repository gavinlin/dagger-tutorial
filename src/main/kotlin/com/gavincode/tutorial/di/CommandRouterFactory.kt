package com.gavincode.tutorial.di

import com.gavincode.tutorial.CommandRouter
import dagger.Component

@Component
interface CommandRouterFactory {
    fun router(): CommandRouter
}