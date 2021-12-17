package com.example.virtualbadges.view.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.virtualbadges.R
import com.example.virtualbadges.databinding.HomeFragmentLayoutBinding
import com.example.virtualbadges.databinding.SearchFragmentLayoutBinding

class SearchFragment:Fragment() {
    private lateinit var mBinding:SearchFragmentLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding= SearchFragmentLayoutBinding.inflate(inflater,container,false)
        mBinding.fragment=this
        return mBinding.root
    }
}