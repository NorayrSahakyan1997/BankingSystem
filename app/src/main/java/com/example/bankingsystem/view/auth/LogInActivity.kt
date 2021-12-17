package com.example.bankingsystem.view.auth
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.bankingsystem.R
import com.example.bankingsystem.databinding.ActivityLogInBinding
import com.example.bankingsystem.shared.*
import com.example.bankingsystem.view.home.HomeActivity
import com.example.bankingsystem.view.root.BaseActivity

class LogInActivity : BaseActivity() {
    private lateinit var mBinding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_log_in)
        mBinding.isLoading = true
        mBinding.activity = this
        changeColorOfLettersInText()
    }

    fun logIn() {
        val isUserNameValid = InputChecker.isUserInfoValid(mBinding.userPhoneNumber)
        val isUserPasswordValid = InputChecker.isUserPasswordValid(mBinding.passwordInput)
        val userNameIsInvalidMessage = resources.getString(R.string.userNameIsInvalid)
        val userPasswordIsInvalidMessage = resources.getString(R.string.userPasswordIsInvalid)
        if (!isUserNameValid) {
            Snack.createSnack(mBinding.root, userNameIsInvalidMessage)
        } else {
            if (!isUserPasswordValid) {
                Snack.createSnack(mBinding.root, userPasswordIsInvalidMessage)
            } else {
                fillBodyForm()
            }
        }
    }

    fun signUp() {
        ChangeActivity.enterActivity(this, SignUpActivity())
    }

    private fun fillBodyForm() {
        val phoneNumber = mBinding.userPhoneNumber.text.toString()
        val password = mBinding.passwordInput.text.toString()
        val token = phoneNumber.plus(password)
        checkUser(token)
    }

    override fun logInUser(isLoggedIn: Boolean) {
        super.logInUser(isLoggedIn)
        if (isLoggedIn) {
            ChangeActivity.enterActivity(this, HomeActivity())
        } else {
            Snack.createSnack(mBinding.root, resources.getString(R.string.noSuchUSerFound))
        }
    }

    private fun changeColorOfLettersInText() {
        val content = resources.getString(R.string.doNotHaveAccount)
        val end = 8
        mBinding.doNotHaveAccountText.setText(
            TextStyler.changeColorOfLettersInText(
                this,
                content,
                end
            ), TextView.BufferType.SPANNABLE
        )
    }


}