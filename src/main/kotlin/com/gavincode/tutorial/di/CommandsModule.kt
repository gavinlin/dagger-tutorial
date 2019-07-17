package com.gavincode.tutorial.di

import com.gavincode.tutorial.Database
import com.gavincode.tutorial.command.Command
import com.gavincode.tutorial.command.HelloWorldCommand
import com.gavincode.tutorial.command.LoginCommand
import dagger.Binds
import dagger.BindsOptionalOf
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface CommandsModule {

    @Binds
    @IntoMap
    @StringKey("hello")
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command

    @Binds
    @IntoMap
    @StringKey("login")
    fun loginCommand(command: LoginCommand): Command

    @BindsOptionalOf
    fun optionalAccount(): Database.Account
}