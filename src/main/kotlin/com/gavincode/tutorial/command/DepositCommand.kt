package com.gavincode.tutorial.command

import com.gavincode.tutorial.Database
import com.gavincode.tutorial.Outputter
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val database: Database,
    private val outputter: Outputter
): Command {

    override fun handleInput(input: List<String>): Command.Result {
        if (input.size != 2) {
            return Command.Result.invalid()
        }

        val account = database.getAccount(input[0])
        account.deposit(BigDecimal(input[1]))
        outputter.output(
            "${account.username} now has: ${account.balance}")
        return Command.Result.handled()
    }
}