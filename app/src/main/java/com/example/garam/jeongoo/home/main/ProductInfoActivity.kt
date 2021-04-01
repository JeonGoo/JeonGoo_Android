package com.example.garam.jeongoo.home.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.garam.jeongoo.R

class ProductInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info)

        val viewPager = findViewById<ViewPager2>(R.id.productImageViewPager)
        val fragmentAdapter = ImageFragmentAdapter(this)
        viewPager.adapter = fragmentAdapter
    }
}