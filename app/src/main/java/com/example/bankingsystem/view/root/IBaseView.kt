package com.example.bankingsystem.view.root

import android.accounts.Account
import com.example.bankingsystem.model.Client
import com.example.bankingsystem.shared.Utility

interface IBaseView {

    fun onToast(message: String?)

    fun onSnackBar(message: String?)

    fun showServerError()

    fun showNetworkError()

    fun logInUser(isLoggedIn: Boolean)

    fun makeTransaction(sendAccount: Account, receiverAccount: Account)

    fun showBalance(account: Account)

    fun payUtility(account: Account,utility:Utility)

    fun addClient(key: String, client: Client)

    fun addAccount(key: String, account: Account)

}