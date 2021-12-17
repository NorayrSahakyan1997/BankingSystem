package com.example.bankingsystem.view.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bankingsystem.databinding.TransactionFragmentLayoutBinding
import com.example.bankingsystem.shared.ChangeActivity
import com.example.bankingsystem.shared.Constants
import com.example.bankingsystem.shared.SharedPreferencesHelper
import com.example.bankingsystem.shared.Snack
import com.example.bankingsystem.view.home.MakeTransactionActivity

class TransactionFragment : Fragment() {
    private lateinit var mBinding: TransactionFragmentLayoutBinding
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = TransactionFragmentLayoutBinding.inflate(inflater, container, false)
        mBinding.fragment = this
        sharedPreferencesHelper = SharedPreferencesHelper(requireActivity())
        return mBinding.root
    }

    fun makeTransaction() {
        val token = sharedPreferencesHelper.getStringSharedPreferences(Constants.TOKEN)
        val client = sharedPreferencesHelper.getObject(token!!)
        val account = client!!.account
        if (account == null) {
            Snack.createSnack(mBinding.root, "Please activate you account")
        } else {
            ChangeActivity.enterActivity(requireActivity() as AppCompatActivity, MakeTransactionActivity())
        }
    }
}