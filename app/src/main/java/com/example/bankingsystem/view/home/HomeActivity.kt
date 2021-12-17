package com.example.bankingsystem.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bankingsystem.R
import com.example.bankingsystem.databinding.ActivityHomeBinding
import com.example.bankingsystem.databinding.TabBarIncludeBinding
import com.example.bankingsystem.shared.CallBackAmongActivities
import com.example.bankingsystem.shared.Constants.HOME_FRAGMENT_TAG
import com.example.bankingsystem.shared.Constants.PROFILE_FRAGMENT_TAG
import com.example.bankingsystem.shared.Constants.SEARCH_FRAGMENT_TAG
import com.example.bankingsystem.shared.Constants.SETTINGS_FRAGMENT_TAG
import com.example.bankingsystem.shared.SelectTab
import com.example.bankingsystem.view.home.fragments.DepositFragment
import com.example.bankingsystem.view.home.fragments.HomeFragment
import com.example.bankingsystem.view.home.fragments.SettingsFragment
import com.example.bankingsystem.view.home.fragments.TransactionFragment

class HomeActivity : AppCompatActivity(), CallBackAmongActivities {
    private lateinit var mBinding: ActivityHomeBinding
    private lateinit var tabBarBinding: TabBarIncludeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        mBinding.activity = this
        tabBarBinding = mBinding.tabBar
        addFragmentHome()
        enterHome()
        enterSettings()
        enterDeposit()
        enterTransaction()
    }

    private fun enterHome() {
        tabBarBinding.homeLayout.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(
                R.id.homeContainer,
                HomeFragment(this), HOME_FRAGMENT_TAG
            ).commit()
            SelectTab.makeTabActive(
                this,
                tabBarBinding,
                tabBarBinding.homeImage,
                tabBarBinding.homeText
            )
        }
    }

    private fun enterSettings() {
        tabBarBinding.settingsLayout.setOnClickListener {
            makeSettingsActive()
        }
    }

    private fun enterDeposit() {
        tabBarBinding.depositLayout.setOnClickListener {
            SelectTab.makeTabActive(
                this,
                tabBarBinding,
                tabBarBinding.depositImage,
                tabBarBinding.depositText
            )
            supportFragmentManager.beginTransaction()
                .replace(R.id.homeContainer, DepositFragment(), SEARCH_FRAGMENT_TAG).commit()
        }
    }

    private fun enterTransaction() {
        tabBarBinding.transactionLayout.setOnClickListener {
            makeTransactionActive()
        }
    }

    private fun addFragmentHome() {
        SelectTab.makeTabActive(
            this,
            tabBarBinding,
            tabBarBinding.homeImage,
            tabBarBinding.homeText
        )
        supportFragmentManager.beginTransaction()
            .add(R.id.homeContainer, HomeFragment(this), HOME_FRAGMENT_TAG).commit()
    }

    private fun makeSettingsActive() {
        SelectTab.makeTabActive(
            this,
            tabBarBinding,
            tabBarBinding.settingsImage,
            tabBarBinding.settingsText
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.homeContainer, SettingsFragment(), SETTINGS_FRAGMENT_TAG).commit()
    }

    private fun makeTransactionActive() {
        SelectTab.makeTabActive(
            this,
            tabBarBinding,
            tabBarBinding.transactionImage,
            tabBarBinding.transactionText
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.homeContainer, TransactionFragment(), PROFILE_FRAGMENT_TAG).commit()
    }

    override fun openSettingsFragment() {
        makeSettingsActive()
    }

    override fun openTransactionFragment() {
        makeTransactionActive()
    }
}