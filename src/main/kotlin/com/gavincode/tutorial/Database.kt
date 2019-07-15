package com.gavincode.tutorial

import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor() {

    private val accounts: MutableMap<String, Account> = mutableMapOf()

    fun getAccount(username: String): Account {
        return accounts.computeIfAbsent(username) {
            Account(it)
        }
    }

    data class Account(val username: String, var balance: BigDecimal = BigDecimal.ZERO) {
        fun deposit(bigDecimal: BigDecimal) {
            this.balance = bigDecimal
        }
    }
}