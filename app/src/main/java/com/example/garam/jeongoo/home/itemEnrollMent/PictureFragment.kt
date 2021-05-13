package com.example.garam.jeongoo.home.itemEnrollMent

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.databinding.FragmentPictureBinding

class PictureFragment : Fragment() {

    private lateinit var dialog : Dialog
    private lateinit var binding: FragmentPictureBinding
    private lateinit var itemEnrollViewModelViewModel: ItemEnrollViewModel

    fun newInstance(): PictureFragment {
        return PictureFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        itemEnrollViewModelViewModel = ViewModelProvider(this.requireActivity()).get(ItemEnrollViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_picture,container,false)
        binding.lifecycleOwner = this.requireActivity()

        binding.productImageCapture.setOnClickListener {
            val intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,1)
        }

        binding.enrollPreviousButton.setOnClickListener {
            val activity : ItemEnrollActivity = activity as ItemEnrollActivity
            activity.testReplaceFragment(activity.enroll,this)
        }
        dialog = Dialog(this.requireActivity())
        dialog.setContentView(R.layout.enroll_complete_dialog)

        binding.enrollCompleteButton.setOnClickListener {
            itemEnrollViewModelViewModel.productRegister()
            showDialog()
        }

        return binding.root
    }

    private fun showDialog() {
        dialog.show()

        val button = dialog.findViewById<Button>(R.id.enrollConfirmButton)
        button.setOnClickListener {
            this.activity?.finish()
        }
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