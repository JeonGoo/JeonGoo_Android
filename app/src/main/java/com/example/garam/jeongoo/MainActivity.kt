package com.example.garam.jeongoo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.garam.jeongoo.databinding.ActivityMainBinding
import com.example.garam.jeongoo.viewModel.JeonGooViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : JeonGooViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(JeonGooViewModel::class.java)
        binding.viewModel = viewModel

        binding.loginButton.setOnClickListener {

            val nextIntent = Intent(this, HomeActivity::class.java)
            startActivity(nextIntent)

        }

        binding.signUpButton.setOnClickListener {

        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkPermission() {
        if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED ||
                checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE),100)
        }
    }
}