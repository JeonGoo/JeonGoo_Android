package com.example.garam.jeongoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.garam.jeongoo.databinding.ActivitySignUpBinding
import com.example.garam.jeongoo.viewModel.JeonGooViewModel

class SignUpActivity : AppCompatActivity() {

    private lateinit var viewModel : JeonGooViewModel
    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(JeonGooViewModel::class.java)
        binding.signUpData = viewModel
    }
}