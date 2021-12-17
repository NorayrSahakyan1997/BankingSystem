package com.example.bankingsystem.shared
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.bankingsystem.R

object ChangeActivity {
    fun enterActivity(activity: AppCompatActivity, enteringActivity: AppCompatActivity) {
        val intent = Intent(activity, enteringActivity::class.java)
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

}