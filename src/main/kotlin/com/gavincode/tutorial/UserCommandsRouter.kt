package com.gavincode.tutorial

import com.gavincode.tutorial.di.PerSession
import com.gavincode.tutorial.di.UserCommandsModule
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@PerSession
@Subcomponent(modules = [UserCommandsModule::class])
interface UserCommandsRouter  {
    fun router(): CommandRouter

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance account: Database.Account)
                : UserCommandsRouter
    }

    @Module(subcomponents = [UserCommandsRouter::class])
    interface InstallationModule {}
}