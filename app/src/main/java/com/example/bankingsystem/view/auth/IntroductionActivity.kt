package com.example.bankingsystem.view.auth
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.bankingsystem.R
import com.example.bankingsystem.databinding.IntroductionActivityLayoutBinding
import com.example.bankingsystem.shared.ChangeActivity

class IntroductionActivity : AppCompatActivity() {
    private lateinit var mBinding: IntroductionActivityLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=DataBindingUtil.setContentView(this, R.layout.introduction_activity_layout)
        mBinding.activity=this
    }
    fun logIn() {
        ChangeActivity.enterActivity(this,LogInActivity())
    }

    fun signUp() {
        ChangeActivity.enterActivity(this,SignUpActivity())
    }

}