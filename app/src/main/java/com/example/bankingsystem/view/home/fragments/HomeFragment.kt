package com.example.bankingsystem.view.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bankingsystem.databinding.HomeFragmentLayoutBinding
import com.example.bankingsystem.shared.CallBackAmongActivities
import com.example.bankingsystem.shared.ChangeActivity
import com.example.bankingsystem.view.addAccount.ActivateAccount

class HomeFragment(private var callBack:CallBackAmongActivities) : Fragment() {
    private lateinit var mBinding: HomeFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = HomeFragmentLayoutBinding.inflate(inflater, container, false)
        mBinding.fragment = this
        return mBinding.root
    }
    fun addAccount(){
        ChangeActivity.enterActivity(activity as AppCompatActivity,ActivateAccount())
    }
    fun openSettings(){
        callBack.openSettingsFragment()
    }
    fun openTransaction(){
        callBack.openTransactionFragment()
    }
}