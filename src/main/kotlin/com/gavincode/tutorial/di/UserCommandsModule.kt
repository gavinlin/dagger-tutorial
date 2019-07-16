package com.gavincode.tutorial.di

import com.gavincode.tutorial.command.Command
import com.gavincode.tutorial.command.DepositCommand
import com.gavincode.tutorial.command.LogoutCommand
import com.gavincode.tutorial.command.WithdrawCommand
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    fun depositCommand(command: DepositCommand): Command

    @Binds
    @IntoMap
    @StringKey("withdraw")
    fun withdrawCommand(command: WithdrawCommand): Command

    @Binds
    @IntoMap
    @StringKey("logout")
    fun  logoutCommand(command: LogoutCommand): Command
}