package com.gavincode.tutorial.command

import com.gavincode.tutorial.Database
import com.gavincode.tutorial.Outputter
import com.gavincode.tutorial.UserCommandsRouter
import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val outputter: Outputter,
    private val database: Database,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory
) : SingleArgCommand() {

    override fun handleArg(username: String): Command.Result {
        val account = database.getAccount(username)
        outputter.output(
            "${account.username} is logged in with balance: ${account.balance}")
        return Command.Result.enterNestedCommandSet(
            userCommandsRouterFactory.create(account).router())
    }

}