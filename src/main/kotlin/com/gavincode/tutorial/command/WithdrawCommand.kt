package com.gavincode.tutorial.command

import com.gavincode.tutorial.Database
import com.gavincode.tutorial.Outputter
import com.gavincode.tutorial.di.MaximumWithdrawal
import com.gavincode.tutorial.di.MinimumBalance
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand @Inject constructor(
    private val outputter: Outputter,
    private val account: Database.Account,
    @MinimumBalance private val minimumBalance: BigDecimal,
    @MaximumWithdrawal private val maximumWithdrawal: BigDecimal
): BigDecimalCommand(outputter) {
    override fun handleAmount(amount: BigDecimal) {
        if (amount > maximumWithdrawal) {
            outputter.output("Cannot withdraw, the maximum amount of withdrawal is $maximumWithdrawal")
            return
        }

        val newBalance = account.balance.subtract(amount)
        if (newBalance < minimumBalance) {
            outputter.output("No enough money")
            return
        } else {
            account.withdraw(amount)
            outputter.output("your new balance is: ${account.balance}")
        }
    }
}