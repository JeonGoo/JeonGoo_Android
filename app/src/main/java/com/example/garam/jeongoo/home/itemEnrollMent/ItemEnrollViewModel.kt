package com.example.garam.jeongoo.home.itemEnrollMent

import android.app.Application
import android.util.Log
import android.widget.Button
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.garam.jeongoo.PreferenceManager
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.data.ProductBasicInfoRequest
import com.example.garam.jeongoo.data.ProductRequest
import com.example.garam.jeongoo.network.NetworkController
import com.example.garam.jeongoo.network.NetworkService
import com.google.gson.JsonObject
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

class ItemEnrollViewModel : ViewModel() {

    private val networkService : NetworkService by lazy {
        NetworkController.instance.networkService
    }

    val productName = MutableLiveData<String> ()
    val productInfo = MutableLiveData<String> ()
    val productDescription = MutableLiveData<String> ()
    var productPrice = MutableLiveData<String> ()
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
                    Log.e("Test", productStatus.value.toString())
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
                    Log.e("Test", productStatus.value.toString())
                }
            }
        }
    }

    fun productRegister() {

        networkService.productEnroll(token.value.toString()
            ,ProductRequest(ProductBasicInfoRequest.FileInfoRequest(arrayListOf(null)),
            ProductBasicInfoRequest(
                productName.value.toString(),"0000",productStatus.value.toString(),
                productDescription.value.toString(),productPrice.value!!.toInt()
            )
        ),userId.value!!.toInt()).enqueue(object : Callback<JsonObject>{

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {

            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val res = response.body()!!
                Log.e("response", res.toString())
            }
        })
    }

}