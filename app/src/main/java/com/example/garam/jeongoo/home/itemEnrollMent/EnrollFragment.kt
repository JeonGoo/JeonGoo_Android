package com.example.garam.jeongoo.home.itemEnrollMent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.garam.jeongoo.R
class EnrollFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_enroll, container, false)

        root.findViewById<Button>(R.id.enrollNextButton).setOnClickListener {
            val activity : ItemEnrollActivity = activity as ItemEnrollActivity
            activity.replaceFragment(PictureFragment().newInstance(),this)
        }

        return root
    }
}