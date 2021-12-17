package com.example.bankingsystem.shared

import android.content.Context
import android.text.TextUtils
import android.widget.EditText
import com.example.bankingsystem.R
import com.example.bankingsystem.databinding.ActivityActiviateAccountBinding
import com.example.bankingsystem.databinding.ActivitySignUpBinding

object InputChecker {
    fun isUserInfoValid(input: EditText): Boolean {
        val inputValue = input.text.toString()
        return (inputValue.isNotEmpty())
    }

    fun isUserPasswordValid(input: EditText): Boolean {
        val inputValue = input.text.toString()
        return (inputValue.length >= 6 && inputValue.isNotEmpty())
    }

    private fun isUserMailValid(input: EditText): Boolean {
        val inputValue = input.text.toString()
        return if (TextUtils.isEmpty(inputValue)) {
            false
        } else {
            android.util.Patterns.EMAIL_ADDRESS.matcher(inputValue).matches()
        }
    }

    fun isSignUpFieldsValid(context: Context, mBinding: ActivitySignUpBinding): Boolean {
        val isUserNameValid = isUserInfoValid(mBinding.userName)
        val userNameIsInvalidMessage = context.resources.getString(R.string.userNameIsInvalid)
        val userEmailIsInvalidMessage = context.resources.getString(R.string.userMailIsInvalid)
        val isUserMailValid = isUserMailValid(mBinding.userMailInput)
        val isUserPasswordValid = isUserPasswordValid(mBinding.passwordInput)
        val userPasswordIsInvalidMessage =
            context.resources.getString(R.string.userPasswordIsInvalid)
        val userPassword = mBinding.passwordInput.text.toString()
        val userPasswordRepeat = mBinding.repeatPassword.text.toString()
        val signUp: Boolean

        if (!isUserNameValid) {
            signUp = false
            Snack.createSnack(mBinding.root, userNameIsInvalidMessage)
        } else {
            if (!isUserMailValid) {
                signUp = false
                Snack.createSnack(mBinding.root, userEmailIsInvalidMessage)
            } else {
                if (!isUserPasswordValid) {
                    signUp = false
                    Snack.createSnack(mBinding.root, userPasswordIsInvalidMessage)
                } else {
                    if (userPassword != userPasswordRepeat) {
                        signUp = false
                        Snack.createSnack(
                            mBinding.root,
                            context.resources.getString(R.string.userRepeatPasswordIsInvalid)
                        )
                    } else {
                        signUp = true
                    }
                }
            }
        }
        return signUp
    }
    fun isCreateAccountFieldsValid(mBinding: ActivityActiviateAccountBinding): Boolean {
        val isAccountTypeValid = isUserInfoValid(mBinding.accountType)
        val isUserAddressValid = isUserInfoValid(mBinding.address)
        val isPhoneNumberValid = isUserInfoValid(mBinding.userPhoneNumber)
        val isSocialCardValid = isUserInfoValid(mBinding.socialNumber)
        return isAccountTypeValid && isUserAddressValid && isPhoneNumberValid && isSocialCardValid
    }
}
