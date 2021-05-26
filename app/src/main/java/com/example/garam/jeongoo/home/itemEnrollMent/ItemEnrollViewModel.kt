package com.example.garam.jeongoo.home.itemEnrollMent

import android.util.Log
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.network.NetworkController
import com.example.garam.jeongoo.network.NetworkService
import com.google.gson.JsonObject
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class ItemEnrollViewModel : ViewModel() {

    private val networkService : NetworkService by lazy {
        NetworkController.instance.networkService
    }

    val productName = MutableLiveData<String> ()
    val productInfo = MutableLiveData<String> ()
    val productDescription = MutableLiveData<String> ()
    var productPrice = MutableLiveData<String> ()
    val fileList = MutableLiveData<File>()
    private val productStatus = MutableLiveData<String> ()

    val token = MutableLiveData<String>()
    val userId = MutableLiveData<Int>()

    fun setProductType(button: Button) {
        when(button.id) {
            R.id.newProductButton ->{
                if(button.isSelected) {
                    button.isSelected = false
                    productStatus.value = ""
                }
                else {
                    button.isSelected = true
                    productStatus.value = "DISUSED"
                }
            }

            R.id.oldProductButton -> {
                if (button.isSelected) {
                    button.isSelected = false
                    productStatus.value = ""
                }
                else {
                    button.isSelected = true
                    productStatus.value = "USED"
                }
            }
        }
    }

    fun productRegister() {
        val requestFile = RequestBody.create(MediaType.parse("image/*"), fileList.value!!.absoluteFile)
        val body = MultipartBody.Part.createFormData("imageFiles","${productName.value}-${System.currentTimeMillis()}",requestFile)

        val status = MultipartBody.Part.createFormData("useStatus",productStatus.value.toString())
        val description = MultipartBody.Part.createFormData("description",productDescription.value.toString())
        val name = MultipartBody.Part.createFormData("name",productName.value.toString())
        val price = MultipartBody.Part.createFormData("price",productPrice.value.toString())
        val serial = MultipartBody.Part.createFormData("serialNumber","0000")

        val requestVideo = RequestBody.create(MediaType.parse("video/*"),fileList.value!!.absoluteFile)
        val testVideo = MultipartBody.Part.createFormData("videoFile","${productName.value}-${System.currentTimeMillis()}",requestVideo)

        networkService.productRegister(body , testVideo,
        userId.value!!.toInt(),description,name,
            price,serial,status).enqueue(object : Callback<JsonObject>{
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {

            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val res = response.body()!!
                Log.e("res",res.toString())
            }
        })
    }

}