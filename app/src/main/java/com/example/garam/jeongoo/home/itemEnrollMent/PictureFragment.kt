package com.example.garam.jeongoo.home.itemEnrollMent

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.databinding.FragmentPictureBinding

class PictureFragment : Fragment() {

    private lateinit var binding: FragmentPictureBinding

    fun newInstance(): PictureFragment {
        return PictureFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_picture,container,false)

        binding.productImageCapture.setOnClickListener {
            val intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,1)
        }

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK && data?.data != null) {
                    val bitmap = data.extras?.get("data") as Bitmap
                    val image = binding.productImageCapture
                    Glide.with(this).load(bitmap).into(image)
                }
                else {
                    Toast.makeText(activity,"취소되었습니다",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}