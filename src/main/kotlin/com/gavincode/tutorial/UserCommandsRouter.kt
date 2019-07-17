package com.gavincode.tutorial

import com.gavincode.tutorial.di.*
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@PerSession
@Subcomponent(modules = [
    UserCommandsModule::class,
    AccountModule::class,
    AmountsModule::class])
interface UserCommandsRouter  {
    fun router(): CommandRouter

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @Username username: String)
                : UserCommandsRouter
    }

    @Module(subcomponents = [UserCommandsRouter::class])
    interface InstallationModule
}