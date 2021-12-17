package com.example.virtualbadges.view.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.virtualbadges.R
import com.example.virtualbadges.databinding.ProfileFragmentLayoutBinding

class ProfileFragment:Fragment() {
    private lateinit var mBinding:ProfileFragmentLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding=ProfileFragmentLayoutBinding.inflate(inflater,container,false)
        mBinding.fragment=this
        return mBinding.root
    }
}