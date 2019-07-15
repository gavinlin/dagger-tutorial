package com.gavincode.tutorial.command

import com.gavincode.tutorial.Outputter
import javax.inject.Inject

class LoginCommand @Inject constructor(
    protected val outputter: Outputter
) : SingleArgCommand() {
    override fun key(): String = "login"

    override fun handleArg(username: String): Command.Status {
        outputter.output("$username is logged in.")
        return Command.Status.HANDLED
    }

}