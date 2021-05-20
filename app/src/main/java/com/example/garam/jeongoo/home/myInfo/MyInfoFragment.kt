package com.example.garam.jeongoo.home.myInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.garam.jeongoo.PreferenceManager
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.databinding.FragmentMyInfoBinding

class MyInfoFragment : Fragment() {

    private lateinit var myInfoViewModel: MyInfoViewModel
    private lateinit var binding: FragmentMyInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myInfoViewModel = ViewModelProvider(this.requireActivity()).get(MyInfoViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_info,container,false)
        binding.lifecycleOwner = this
        binding.myInfoViewModel = myInfoViewModel

        val preferenceManager = PreferenceManager()
        myInfoViewModel.userId.value = preferenceManager.getId(this.requireContext(),"userId")
        myInfoViewModel.token.value = preferenceManager.getToken(this.requireContext(),"token")

        return binding.root
    }
}