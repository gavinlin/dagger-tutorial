package com.gavincode.tutorial.di

import com.gavincode.tutorial.CommandProcessor
import com.gavincode.tutorial.UserCommandsRouter
import com.gavincode.tutorial.command.DepositCommand
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    LoginCommandModule::class,
    HelloWorldModule::class,
    SystemOutModule::class,
    UserCommandsRouter.InstallationModule::class,
    AmountsModule::class])
interface CommandProcessorFactory{
    fun processor(): CommandProcessor
}
