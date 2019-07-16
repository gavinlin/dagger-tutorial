package com.gavincode.tutorial.command

import com.gavincode.tutorial.Outputter
import java.lang.NumberFormatException
import java.math.BigDecimal


abstract class BigDecimalCommand constructor(
    private val outputter: Outputter
): SingleArgCommand() {

    companion object {
        fun tryParse(arg: String): BigDecimal? {
            return try {
                BigDecimal(arg)
            } catch (e : NumberFormatException) {
                null
            }
        }
    }

    override fun handleArg(arg: String): Command.Result {
        val amount = tryParse(arg)
        when {
            amount == null -> outputter.output("$arg is not a valid number")
            amount.signum() <= 0 -> outputter.output("amount must be positive")
            else -> handleAmount(amount)
        }
        return Command.Result.handled()
    }

    protected abstract fun handleAmount(amount: BigDecimal)
}