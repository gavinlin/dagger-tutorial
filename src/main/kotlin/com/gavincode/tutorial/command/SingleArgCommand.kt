package com.gavincode.tutorial.command

abstract class SingleArgCommand : Command {

    override fun handleInput(input: List<String>): Command.Result {
        return if (input.size == 1) handleArg(input[0]) else Command.Result.invalid()
    }

    protected abstract fun handleArg(arg: String): Command.Result
}