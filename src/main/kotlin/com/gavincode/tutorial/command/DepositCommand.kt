package com.gavincode.tutorial.command

import com.gavincode.tutorial.Database
import com.gavincode.tutorial.Outputter
import com.gavincode.tutorial.WithdrawalLimiter
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val account: Database.Account,
    private val outputter: Outputter,
    private val withdrawalLimiter: WithdrawalLimiter
): BigDecimalCommand(outputter) {

    override fun handleAmount(amount: BigDecimal) {
        account.deposit(amount)
        withdrawalLimiter.recordDeposit(amount)
        outputter.output("${account.username} now has: ${account.balance}")
    }
}