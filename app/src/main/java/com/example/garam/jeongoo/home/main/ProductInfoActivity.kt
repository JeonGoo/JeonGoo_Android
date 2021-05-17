package com.example.garam.jeongoo.home.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.databinding.ActivityProductInfoBinding

class ProductInfoActivity : AppCompatActivity() {

    private lateinit var mainFragmentViewModel: MainFragmentViewModel
    private lateinit var binding: ActivityProductInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_product_info)

        mainFragmentViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)

        binding.lifecycleOwner = this
        binding.mainFragmentViewModel = mainFragmentViewModel

        val id = intent.getIntExtra("productId",0)
        mainFragmentViewModel.getDetailProductInfo(id)
        mainFragmentViewModel.productId.value = id

        val viewPager = findViewById<ViewPager2>(R.id.productImageViewPager)
        val fragmentAdapter = ImageFragmentAdapter(this)
        viewPager.adapter = fragmentAdapter



        findViewById<TextView>(R.id.detailProductInfoNameTextView).text = id.toString()

    }
}