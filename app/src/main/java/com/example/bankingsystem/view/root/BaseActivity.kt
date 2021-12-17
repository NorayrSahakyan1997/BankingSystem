package com.example.bankingsystem.view.root
import android.accounts.Account
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.example.bankingsystem.model.Client
import com.example.bankingsystem.shared.Constants
import com.example.bankingsystem.shared.SharedPreferencesHelper
import com.example.bankingsystem.shared.Utility

open class BaseActivity : AppCompatActivity(), IBaseView {
    private lateinit var dataStore: DataStore<Preferences>
    lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    protected  lateinit var token:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataStore = createDataStore(Constants.PREFERENCE_MANAGER_TAG)
        sharedPreferencesHelper = SharedPreferencesHelper(this)
        if(sharedPreferencesHelper.getStringSharedPreferences(Constants.TOKEN)!=null){
            token = sharedPreferencesHelper.getStringSharedPreferences(Constants.TOKEN)!!
        }
    }

    override fun onToast(message: String?) {
    }

    override fun onSnackBar(message: String?) {
    }

    override fun showServerError() {
    }

    override fun showNetworkError() {
    }

    override fun logInUser(isLoggedIn: Boolean) {

    }

    override fun makeTransaction(sendAccount: Account, receiverAccount: Account) {

    }

    override fun showBalance(account: Account) {

    }

    override fun payUtility(account: Account, utility: Utility) {

    }

    protected fun checkUser(key: String) {
        val result = sharedPreferencesHelper.getObject(key)
        if (result != null) {
            logInUser(true)
        } else {
            logInUser(false)
        }
    }
    protected fun getClient(key: String):Client? {
        val result = sharedPreferencesHelper.getObject(key)
        if (result != null) {
            logInUser(true)
        } else {
            logInUser(false)
        }
        return result
    }

    override fun addClient(key: String, client: Client) {
        sharedPreferencesHelper.setStringSharedPreferences(Constants.TOKEN,key)
        sharedPreferencesHelper.setObjectInSharedPreferences(key, client)
    }

    override fun addAccount(key: String, account: Account) {

    }


}