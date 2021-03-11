package com.example.garam.jeongoo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.garam.jeongoo.databinding.ActivityMainBinding
import com.example.garam.jeongoo.viewModel.JeonGooViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : JeonGooViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(JeonGooViewModel::class.java)
        binding.viewModel = viewModel

        val nextIntent = Intent(this, HomeActivity::class.java)
        startActivity(nextIntent)

    }
}