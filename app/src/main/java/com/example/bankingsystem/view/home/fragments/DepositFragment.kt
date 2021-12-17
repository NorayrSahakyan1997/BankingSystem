package com.example.bankingsystem.view.home.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bankingsystem.databinding.DepositFragmentLayoutBinding

class DepositFragment : Fragment() {
    private lateinit var mBinding: DepositFragmentLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding= DepositFragmentLayoutBinding.inflate(inflater,container,false)
        mBinding.fragment=this
        return mBinding.root
    }

}