package com.example.garam.jeongoo.home.itemEnrollMent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.garam.jeongoo.R

class PictureFragment : Fragment() {

    fun newInstance(): PictureFragment {
        return PictureFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_picture, container, false)

        return root
    }

}