package com.example.bankingsystem.model

data class Account(
    val clientId: String,
    val accountType: String,
    var balance: Float,
    val id: String
)