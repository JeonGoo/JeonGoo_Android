package com.example.garam.jeongoo.home.itemEnrollMent

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.garam.jeongoo.R

class PictureFragment : Fragment() {

    fun newInstance(): PictureFragment {
        return PictureFragment()
    }

    private lateinit var root : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_picture, container, false)

        root.findViewById<ImageView>(R.id.productImageCapture).setOnClickListener {
            val intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,1)
        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            1 -> {
                val bitmap = data?.extras?.get("data") as Bitmap
                val image = root.findViewById<ImageView>(R.id.productImageCapture)
                Glide.with(this).load(bitmap).into(image)
            }

        }
    }
}