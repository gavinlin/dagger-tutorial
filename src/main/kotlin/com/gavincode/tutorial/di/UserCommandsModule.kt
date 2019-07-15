package com.gavincode.tutorial.di

import com.gavincode.tutorial.command.Command
import com.gavincode.tutorial.command.DepositCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract fun depositCommand(command: DepositCommand): Command
}