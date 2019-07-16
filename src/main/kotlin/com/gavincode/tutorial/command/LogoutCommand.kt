package com.gavincode.tutorial.command

import com.gavincode.tutorial.Database
import com.gavincode.tutorial.Outputter
import javax.inject.Inject

class LogoutCommand @Inject constructor(
    private val outputter: Outputter,
    private val account: Database.Account
) : Command {
    override fun handleInput(input: List<String>): Command.Result {
        return if (input.isEmpty()) {
            outputter.output("logged out ${account.username}")
            Command.Result.inputCompleted()
        } else {
            Command.Result.invalid()
        }
    }
}