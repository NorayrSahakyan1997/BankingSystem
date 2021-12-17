package com.example.virtualbadges.view.home.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.virtualbadges.databinding.SettingsFragmentLayoutBinding
import com.example.virtualbadges.utils.ChangeActivity
import com.example.virtualbadges.view.auth.LogInActivity
import com.example.virtualbadges.view.home.HomeActivity

class SettingsFragment: Fragment(){
    private lateinit var mBinding:SettingsFragmentLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding=SettingsFragmentLayoutBinding.inflate(inflater,container,false)
        mBinding.fragment=this
        return mBinding.root
    }
    fun logOut(){
        ChangeActivity.enterActivity(activity as HomeActivity,LogInActivity())
        (activity as HomeActivity).finish()
    }
}