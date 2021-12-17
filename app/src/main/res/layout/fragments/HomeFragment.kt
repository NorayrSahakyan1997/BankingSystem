package com.example.virtualbadges.view.home.fragments

import androidx.fragment.app.Fragment

import android.os.Bundle

import android.view.ViewGroup

import android.view.LayoutInflater
import android.view.View
import com.example.virtualbadges.R
import com.example.virtualbadges.databinding.HomeFragmentLayoutBinding
import com.example.virtualbadges.databinding.SettingsFragmentLayoutBinding


class HomeFragment :Fragment(){
    private lateinit var mBinding: HomeFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding=HomeFragmentLayoutBinding.inflate(inflater,container,false)
        mBinding.fragment=this
        return mBinding.root
    }
}