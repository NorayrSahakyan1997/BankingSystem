package com.example.bankingsystem
import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

class BankingSystem : Application() {
    private lateinit var dataStore: DataStore<Preferences>

    companion object {
        lateinit var instance: BankingSystem
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }


}