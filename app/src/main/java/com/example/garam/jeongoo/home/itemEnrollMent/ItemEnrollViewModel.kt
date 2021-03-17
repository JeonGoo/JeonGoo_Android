package com.example.garam.jeongoo.home.itemEnrollMent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemEnrollViewModel : ViewModel() {

    val productName = MutableLiveData<String> ()
    val productInfo = MutableLiveData<String> ()
    val productDetailInfo = MutableLiveData<String> ()
    val productPrice = MutableLiveData<String> ()


}