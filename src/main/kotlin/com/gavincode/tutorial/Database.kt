package com.gavincode.tutorial

import java.math.BigDecimal
import javax.inject.Inject

class Database @Inject constructor() {

    private val accounts: MutableMap<String, Account> = mutableMapOf()

    fun getAccount(username: String): Account {
        return accounts.computeIfAbsent(username) {
            Account(it)
        }
    }

    data class Account(val username: String, var balance: BigDecimal = BigDecimal.ZERO)
}