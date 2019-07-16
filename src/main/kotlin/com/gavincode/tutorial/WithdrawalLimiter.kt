package com.gavincode.tutorial

import com.gavincode.tutorial.di.MaximumWithdrawal
import com.gavincode.tutorial.di.PerSession
import java.math.BigDecimal
import javax.inject.Inject

@PerSession
class WithdrawalLimiter @Inject constructor(
    @MaximumWithdrawal private val maximumWithdrawal: BigDecimal
) {
    private var remainingWithdrawalLimit: BigDecimal = maximumWithdrawal

    fun recordDeposit(amount: BigDecimal) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.add(amount)
    }

    fun recordWithdrawal(amount: BigDecimal) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.subtract(amount)
    }

    fun remainingWithdrawalLimit(): BigDecimal {
        return remainingWithdrawalLimit
    }
}