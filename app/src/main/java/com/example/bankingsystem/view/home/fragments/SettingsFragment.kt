package com.example.bankingsystem.view.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bankingsystem.R
import com.example.bankingsystem.databinding.SettingsFragmentLayoutBinding
import com.example.bankingsystem.shared.ChangeActivity
import com.example.bankingsystem.shared.SharedPreferencesHelper
import com.example.bankingsystem.shared.Snack
import com.example.bankingsystem.view.auth.LogInActivity
import com.example.bankingsystem.view.home.HomeActivity

class SettingsFragment : Fragment() {
    private lateinit var mBinding: SettingsFragmentLayoutBinding
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = SettingsFragmentLayoutBinding.inflate(inflater, container, false)
        sharedPreferencesHelper = SharedPreferencesHelper(requireActivity())
        mBinding.fragment = this
        return mBinding.root
    }

    fun logOut() {
        ChangeActivity.enterActivity(activity as HomeActivity, LogInActivity())
        (activity as HomeActivity).finish()
    }

    fun clearData() {
        sharedPreferencesHelper.deleteSharedPreferences()
        Snack.createSnack(mBinding.root, resources.getString(R.string.data_changed_successfully))
    }
}