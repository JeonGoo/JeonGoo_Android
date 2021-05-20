package com.example.garam.jeongoo.home.myInfo

import android.widget.ImageView
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.garam.jeongoo.data.ProductDetailDto
import com.example.garam.jeongoo.data.ResponseProductsData
import com.example.garam.jeongoo.network.NetworkController
import com.example.garam.jeongoo.network.NetworkService
import com.example.garam.jeongoo.util.DataBindingUtils
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyInfoViewModel : ViewModel() {

    private val networkService : NetworkService by lazy {
        NetworkController.instance.networkService
    }

    val productItem = ObservableArrayList<ProductDetailDto>()
    val currentProduct = MutableLiveData<ProductDetailDto>()
    val productId = MutableLiveData<Int>()
    val token = MutableLiveData<String>()
    val userId = MutableLiveData<Int>()

    fun setSaleListOnclick(imageView: ImageView, userId: Int) {
        DataBindingUtils.saleList(imageView,userId)
    }
    fun setPurchasedListOnclick(imageView: ImageView, userId: Int) {
        DataBindingUtils.purchasedList(imageView,userId)
    }

    fun getSellList(userId: Int){
        networkService.sellProducts(userId).enqueue(object : Callback<ResponseProductsData>{
            override fun onFailure(call: Call<ResponseProductsData>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ResponseProductsData>,
                response: Response<ResponseProductsData>
            ) {

            }
        })
    }

    fun getPurchasedList(userId: Int) {
        networkService.purchasedProducts(userId).enqueue(object : Callback<ResponseProductsData>{

            override fun onFailure(call: Call<ResponseProductsData>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ResponseProductsData>,
                response: Response<ResponseProductsData>
            ) {

            }
        })
    }

    fun getInterestedList(interestedUserId: Int) {
        networkService.findInterestProduct(interestedUserId).enqueue(object : Callback<JsonObject>{

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {

            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

            }
        })
    }
}