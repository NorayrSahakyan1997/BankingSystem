package com.example.bankingsystem.view.auth

import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.bankingsystem.R
import com.example.bankingsystem.databinding.ActivitySignUpBinding
import com.example.bankingsystem.model.Client
import com.example.bankingsystem.shared.ChangeActivity
import com.example.bankingsystem.shared.InputChecker
import com.example.bankingsystem.shared.TextStyler
import com.example.bankingsystem.view.home.HomeActivity
import com.example.bankingsystem.view.root.BaseActivity

class SignUpActivity : BaseActivity() {
    private lateinit var mBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        mBinding.activity = this
        mBinding.isLoading = true
        highlightPartOfText()
    }

    fun signUp() {
        if (InputChecker.isSignUpFieldsValid(this, mBinding)) {
            val userName = mBinding.userName.text.toString()
            val userMail = mBinding.userMailInput.text.toString()
            val password = mBinding.passwordInput.text.toString()
            val phoneNumber = mBinding.userPhoneNumber.text.toString()
            val passPortId = mBinding.passportIdInput.text.toString()
            val client = Client(userName, passPortId, userMail, phoneNumber, password, userName,null)
            val token = phoneNumber.plus(password)
            addClient(token, client)
            ChangeActivity.enterActivity(this, HomeActivity())
        }
    }

    fun logIn() {
        ChangeActivity.enterActivity(this, LogInActivity())
        finish()
    }

    private fun highlightPartOfText() {
        mBinding.acceptTermsText.setText(
            TextStyler.changeColorOfLettersInText(
                this,
                resources.getString(R.string.iAcceptTermsAndConditions),
                21
            ), TextView.BufferType.SPANNABLE
        )
        mBinding.haveAccountText.setText(
            TextStyler.changeColorOfLettersInText(
                this,
                resources.getString(R.string.alreadyHaveAccount),
                6
            ), TextView.BufferType.SPANNABLE
        )
    }

}