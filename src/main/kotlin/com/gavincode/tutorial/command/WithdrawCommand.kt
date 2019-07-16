package com.gavincode.tutorial.command

import com.gavincode.tutorial.Database
import com.gavincode.tutorial.Outputter
import com.gavincode.tutorial.WithdrawalLimiter
import com.gavincode.tutorial.di.MaximumWithdrawal
import com.gavincode.tutorial.di.MinimumBalance
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand @Inject constructor(
    private val outputter: Outputter,
    private val account: Database.Account,
    @MinimumBalance private val minimumBalance: BigDecimal,
    private val withdrawalLimiter: WithdrawalLimiter
): BigDecimalCommand(outputter) {
    override fun handleAmount(amount: BigDecimal) {
        val remainingWithdrawalLimit = withdrawalLimiter.remainingWithdrawalLimit()
        if (amount > remainingWithdrawalLimit) {
            outputter.output("you may not withdraw $amount; you may withdraw $remainingWithdrawalLimit more in this session")
            return
        }

        val newBalance = account.balance.subtract(amount)
        if (newBalance < minimumBalance) {
            outputter.output(
                "you don't have sufficient funds to withdraw $amount. your balance is ${account.balance} and the minimum balance is $minimumBalance"
            )
        } else {
            account.withdraw(amount)
            withdrawalLimiter.recordWithdrawal(amount)
            outputter.output("your new balance is: ${account.balance}")
        }
    }
}