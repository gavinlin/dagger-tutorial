package com.gavincode.tutorial.di

import com.gavincode.tutorial.command.Command
import com.gavincode.tutorial.command.HelloWorldCommand
import dagger.Binds
import dagger.Module

@Module
abstract class HelloWorldModule {
    @Binds
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}