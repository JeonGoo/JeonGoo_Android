package com.example.garam.jeongoo.home.main

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.example.garam.jeongoo.data.ProductInfoData

class MainFragmentViewModel : ViewModel() {
    val productItem = ObservableArrayList<ProductInfoData>()

}