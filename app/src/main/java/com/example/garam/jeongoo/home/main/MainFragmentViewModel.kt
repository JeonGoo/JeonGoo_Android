package com.example.garam.jeongoo.home.main

import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.garam.jeongoo.data.ProductDetailDto
import com.example.garam.jeongoo.data.ResponseProductDetailData
import com.example.garam.jeongoo.data.ResponseProductsData
import com.example.garam.jeongoo.network.NetworkController
import com.example.garam.jeongoo.network.NetworkService
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

class MainFragmentViewModel : ViewModel() {

    private val networkService : NetworkService by lazy {
        NetworkController.instance.networkService
    }

    val productItem = ObservableArrayList<ProductDetailDto>()
    val currentProduct = MutableLiveData<ProductDetailDto>()
    val productId = MutableLiveData<Int>()
    val token = MutableLiveData<String>()
    val userId = MutableLiveData<Int>()

    fun getProducts() {
        productItem.clear()
        networkService.findAllProduct().enqueue(object : Callback<ResponseProductsData>{

            override fun onFailure(call: Call<ResponseProductsData>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ResponseProductsData>,
                response: Response<ResponseProductsData>
            ) {
                val res = response.body()!!

                repeat(res.data.size()) {
                    val productDetail = res.data[it].asJsonObject["productDetailDto"]

                    productItem.add(ProductDetailDto(
                        productDetail.asJsonObject["certificationFailedReason"]?.toString(),
                        productDetail.asJsonObject["certificationStatus"]?.asString,
                        productDetail.asJsonObject["description"].asString,
                        productDetail.asJsonObject["fileList"].asJsonArray,
                        productDetail.asJsonObject["id"].asInt,
                        productDetail.asJsonObject["hitCount"].asInt,
                        productDetail.asJsonObject["name"].asString,
                        productDetail.asJsonObject["price"].asInt,
                        productDetail.asJsonObject["productGrade"].asString,
                        productDetail.asJsonObject["useStatus"].asString,
                        productDetail.asJsonObject["salesStatus"].asString,
                        ProductDetailDto.UserShowResponse(res.data[it].asJsonObject["userShowResponse"].asJsonObject["name"].asString,
                            res.data[it].asJsonObject["userShowResponse"].asJsonObject["phoneNumber"].asString)))
                }

            }
        })

    }

    fun getDetailProductInfo(id: Int) {
        networkService.findProduct(id).enqueue(object : Callback<ResponseProductDetailData>{
            override fun onFailure(call: Call<ResponseProductDetailData>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ResponseProductDetailData>,
                response: Response<ResponseProductDetailData>
            ) {
                val res = response.body()!!
                val productDetail = res.data.asJsonObject["productDetailDto"]

                currentProduct.value = ProductDetailDto(
                    productDetail.asJsonObject["certificationFailedReason"]?.toString(),
                    productDetail.asJsonObject["certificationStatus"]?.asString,
                    productDetail.asJsonObject["description"].asString,
                    productDetail.asJsonObject["fileList"].asJsonArray,
                    productDetail.asJsonObject["id"].asInt,
                    productDetail.asJsonObject["hitCount"].asInt,
                    productDetail.asJsonObject["name"].asString,
                    productDetail.asJsonObject["price"].asInt,
                    productDetail.asJsonObject["productGrade"].asString,
                    productDetail.asJsonObject["useStatus"].asString,
                    productDetail.asJsonObject["salesStatus"].asString,
                    ProductDetailDto.UserShowResponse(res.data.asJsonObject["userShowResponse"].asJsonObject["name"].asString,
                        res.data.asJsonObject["userShowResponse"].asJsonObject["phoneNumber"].asString)
                )
            }
        })
    }

    fun purchaseProduct() {
        Log.e("fad","userId : ${userId.value} productId : ${productId.value}")
        networkService.purchase(productId.value!!.toInt(),userId.value!!.toInt()).enqueue(object : Callback<JsonObject>{
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {

            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
            }
        })
    }

}