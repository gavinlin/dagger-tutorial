package com.gavincode.tutorial

import com.gavincode.tutorial.command.Command
import com.gavincode.tutorial.command.HelloWorldCommand
import javax.inject.Inject

class CommandRouter @Inject constructor(
    private val commands: Map<String, @JvmSuppressWildcards Command>
){

    fun route(input: String): Command.Result {
        val splintInput = split(input)

        val commandKey = splintInput[0]

        val command = commands[commandKey] ?: return invalidCommand(input)

        val result = command.handleInput(splintInput.subList(1, splintInput.size))

        return if (result.status == Command.Status.INVALID) {
            invalidCommand(input)
        } else {
            result
        }
    }

    private fun split(string: String): List<String> {
        return string.split(" ")
    }

    private fun invalidCommand(input: String): Command.Result{
        println("couldn't understand \"$input\". please try again.")
        return Command.Result.invalid()
    }
}