package com.example.garam.jeongoo.home.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.garam.jeongoo.R

class MainMenuFragment : Fragment() {

    private lateinit var mainFragmentViewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainFragmentViewModel = ViewModelProvider(this.requireActivity()).get(MainFragmentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_main_menu, container, false)

        return root
    }
}