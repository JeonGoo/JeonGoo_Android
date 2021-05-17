package com.example.garam.jeongoo.home.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.garam.jeongoo.R

class ImageFragment(private val image: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_image, container, false)

        val imageView = root.findViewById<ImageView>(R.id.productMainImage)
        imageView.setImageResource(image)


        return root
    }

}