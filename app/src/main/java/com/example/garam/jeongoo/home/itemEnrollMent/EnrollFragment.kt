package com.example.garam.jeongoo.home.itemEnrollMent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.databinding.FragmentEnrollBinding

class EnrollFragment : Fragment() {

    private lateinit var binding: FragmentEnrollBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_enroll,container,false)

        binding.enrollNextButton.setOnClickListener {
            val activity : ItemEnrollActivity = activity as ItemEnrollActivity
            activity.replaceFragment(PictureFragment().newInstance(),this)
        }

        return binding.root
    }
}