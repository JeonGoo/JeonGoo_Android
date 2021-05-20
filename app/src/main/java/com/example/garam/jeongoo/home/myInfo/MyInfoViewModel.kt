package com.example.garam.jeongoo.home.myInfo

import androidx.lifecycle.ViewModel
import com.example.garam.jeongoo.data.ResponseProductsData
import com.example.garam.jeongoo.network.NetworkController
import com.example.garam.jeongoo.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyInfoViewModel : ViewModel() {

    private val networkService : NetworkService by lazy {
        NetworkController.instance.networkService
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
}