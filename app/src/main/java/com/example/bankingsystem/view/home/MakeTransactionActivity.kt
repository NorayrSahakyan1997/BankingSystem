package com.example.bankingsystem.view.home
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bankingsystem.R
import com.example.bankingsystem.databinding.ActivityMakeTransactionBinding
import com.example.bankingsystem.shared.Constants
import com.example.bankingsystem.shared.Snack
import com.example.bankingsystem.view.root.BaseActivity

class MakeTransactionActivity : BaseActivity() {
    private lateinit var mBinding: ActivityMakeTransactionBinding
    private var userBalance = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_make_transaction)
        mBinding.activity = this
        getBalance()
    }

    private fun getBalance() {
        val token = sharedPreferencesHelper.getStringSharedPreferences(Constants.TOKEN)
        val client = sharedPreferencesHelper.getObject(token!!)
        val account = client!!.account
        userBalance = account!!.balance.toInt()
        mBinding.acceptTermsText.text =
            resources.getString(R.string.available_balance_is).plus(" ".plus(userBalance))
        mBinding.fromAccount.setText(client.phoneNumber)
    }

    fun makeTransaction() {
        val toAccountID = mBinding.toAccount.text.toString()
        val balance = mBinding.balance.text.toString()
        if(toAccountID.isNotEmpty()){
            if(balance.isNotEmpty()){
                if(userBalance<balance.toInt()){
                    Snack.createSnack(mBinding.root,"Balance is unavailable")
                }
                else{
                    if(getClient(toAccountID)!=null){
                        val toAccount=getClient(toAccountID)
                        toAccount!!.account!!.balance= balance.toFloat()
                    }
                    else{
                        Snack.createSnack(mBinding.root,"User is not available")
                    }
                }
            }
            else{
                Snack.createSnack(mBinding.root,"Amount is required")
            }
        }
        else{
            Snack.createSnack(mBinding.root,"Fields are required")
        }
    }
}