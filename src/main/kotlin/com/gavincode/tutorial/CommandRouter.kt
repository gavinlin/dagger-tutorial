package com.gavincode.tutorial

import com.gavincode.tutorial.command.Command
import com.gavincode.tutorial.command.HelloWorldCommand
import javax.inject.Inject

class CommandRouter {

    private val commands: MutableMap<String, Command> = mutableMapOf()

    @Inject
    constructor(helloWorldCommand: HelloWorldCommand) {
        commands.put(helloWorldCommand.key(), helloWorldCommand)
    }

    fun route(input: String): Command.Status {
        val splintInput = split(input)

        val commandKey = splintInput[0]

        val command = commands.get(commandKey) ?: return invalidCommand(input)

        val status = command.handleInput(splintInput.subList(1, splintInput.size))
        if (status == Command.Status.INVALID) {
            println("$commandKey: invalid arguments")
        }
        return status
    }

    private fun split(string: String): List<String> {
        return string.split(" ")
    }

    private fun invalidCommand(input: String): Command.Status {
        println("couldn't understand \"$input\". please try again.")
        return Command.Status.INVALID
    }
}