package com.example.garam.jeongoo.home.itemEnrollMent

import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.garam.jeongoo.R

class ItemEnrollViewModel : ViewModel() {

    val productName = MutableLiveData<String> ()
    val productInfo = MutableLiveData<String> ()
    val productDetailInfo = MutableLiveData<String> ()
    val productPrice = MutableLiveData<String> ()
    private val productType = MutableLiveData<String> ()

    fun setProductType(button: Button) {
        when(button.id) {
            R.id.newProductButton ->{
                if(button.isSelected) {
                    button.isSelected = false
                    productType.value = ""
                }
                else {
                    button.isSelected = true
                    productType.value = "new"
                    Log.e("Test", productType.value.toString())
                }
            }

            R.id.oldProductButton -> {
                if (button.isSelected) {
                    button.isSelected = false
                    productType.value = ""
                }
                else {
                    button.isSelected = true
                    productType.value = "old"
                    Log.e("Test", productType.value.toString())
                }
            }
        }
    }
}