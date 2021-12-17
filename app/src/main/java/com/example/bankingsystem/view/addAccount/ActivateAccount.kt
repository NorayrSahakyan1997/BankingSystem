package com.example.bankingsystem.view.addAccount
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.example.bankingsystem.R
import com.example.bankingsystem.databinding.ActivityActiviateAccountBinding
import com.example.bankingsystem.model.Account
import com.example.bankingsystem.model.Client
import com.example.bankingsystem.shared.ChangeActivity
import com.example.bankingsystem.shared.InputChecker
import com.example.bankingsystem.shared.Snack
import com.example.bankingsystem.view.home.HomeActivity
import com.example.bankingsystem.view.root.BaseActivity

class ActivateAccount : BaseActivity() {
    private lateinit var mBinding: ActivityActiviateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_activiate_account)
        mBinding.activity = this
    }

    fun addAccount() {
        val client = getClient(token)
        val inputsAreValid = InputChecker.isCreateAccountFieldsValid(mBinding)
        if (inputsAreValid) {
            val accountType = mBinding.accountType.text.toString()
            val socialCardNumber = mBinding.socialNumber.text.toString()
            val account = Account(token, accountType, 1000f, socialCardNumber)
            val clientUp = Client(
                client!!.name,
                client.passportId,
                client.email,
                client.phoneNumber,
                client.password,
                client.lastName,
                account
            )
            addClient(token, clientUp)
            Snack.createSnack(mBinding.root, "Account is created successfully")
            waiteTwoSeconds()
        } else {
            Snack.createSnack(mBinding.root, "Fields are required")
        }
    }
    private fun waiteTwoSeconds(){
        Handler(Looper.getMainLooper()).postDelayed(
            {
                ChangeActivity.enterActivity(this, HomeActivity())
            },
            2000 // value in milliseconds
        )
    }
}