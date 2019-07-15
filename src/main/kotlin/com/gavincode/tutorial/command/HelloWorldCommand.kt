package com.gavincode.tutorial.command

import javax.inject.Inject

class HelloWorldCommand @Inject constructor(): Command {

    override fun key(): String = "hello"

    override fun handleInput(input: List<String>): Command.Status {
        if (input.isNotEmpty()) {
            return Command.Status.INVALID
        }
        println("world!")
        return Command.Status.HANDLED
    }

}