package com.gavincode.tutorial.di

import com.gavincode.tutorial.command.Command
import com.gavincode.tutorial.command.LoginCommand
import dagger.Binds
import dagger.Module

@Module
abstract class LoginCommandModule {
    @Binds
    abstract fun loginCommand(command: LoginCommand): Command
}