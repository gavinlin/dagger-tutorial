package com.gavincode.tutorial.di

import com.gavincode.tutorial.Outputter
import dagger.Module
import dagger.Provides

@Module
object SystemOutModule {

    @JvmStatic
    @Provides
    fun textOutputter(): Outputter {
        return object : Outputter {
            override fun output(output: String) {
                println(output)
            }
        }
    }
}