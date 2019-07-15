package com.gavincode.tutorial.command

import com.gavincode.tutorial.Outputter
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(
    private val outputter: Outputter
): Command {

    override fun key(): String = "hello"

    override fun handleInput(input: List<String>): Command.Status {
        if (input.isNotEmpty()) {
            return Command.Status.INVALID
        }
        outputter.output("world!")
        return Command.Status.HANDLED
    }

}