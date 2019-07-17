package com.gavincode.tutorial.di

import com.gavincode.tutorial.Database
import dagger.Module
import dagger.Provides

@Module
object AccountModule {
    @JvmStatic
    @Provides
    fun account(database: Database, @Username username: String): Database.Account {
        return database.getAccount(username)
    }
}