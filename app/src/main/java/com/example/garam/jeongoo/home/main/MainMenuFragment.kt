package com.example.garam.jeongoo.home.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.garam.jeongoo.PreferenceManager
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {

    private lateinit var mainFragmentViewModel: MainFragmentViewModel
    private lateinit var binding: FragmentMainMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentViewModel = ViewModelProvider(this.requireActivity()).get(MainFragmentViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_menu,container,false)
        binding.lifecycleOwner = this
        binding.mainFragmentViewModel = mainFragmentViewModel

        mainFragmentViewModel.getProducts()
        return binding.root
    }
}