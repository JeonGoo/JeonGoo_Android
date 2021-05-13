package com.example.garam.jeongoo.home.main

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.garam.jeongoo.data.ProductDetailDto
import com.example.garam.jeongoo.data.ResponseProductDetailData
import com.example.garam.jeongoo.data.ResponseProductsData
import com.example.garam.jeongoo.network.NetworkController
import com.example.garam.jeongoo.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragmentViewModel : ViewModel() {

    private val networkService : NetworkService by lazy {
        NetworkController.instance.networkService
    }

    val productItem = ObservableArrayList<ProductDetailDto>()
    val currentProduct = MutableLiveData<ProductDetailDto>()

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
                Log.e("데이터",res.toString())
                repeat(res.data.size()) {
                    productItem.add(ProductDetailDto(
                        res.data[it].asJsonObject["productDetailDto"].asJsonObject["certificationFailedReason"]?.toString(),
                        res.data[it].asJsonObject["productDetailDto"].asJsonObject["certificationStatus"]?.asString,
                        res.data[it].asJsonObject["productDetailDto"].asJsonObject["description"].asString,
                        res.data[it].asJsonObject["productDetailDto"].asJsonObject["fileList"].asJsonArray,
                        res.data[it].asJsonObject["productDetailDto"].asJsonObject["id"].asInt,
                        res.data[it].asJsonObject["productDetailDto"].asJsonObject["name"].asString,
                        res.data[it].asJsonObject["productDetailDto"].asJsonObject["price"].asInt,
                        res.data[it].asJsonObject["productDetailDto"].asJsonObject["productGrade"].asString,
                        res.data[it].asJsonObject["productDetailDto"].asJsonObject["useStatus"].asString,
                        res.data[it].asJsonObject["productDetailDto"].asJsonObject["salesStatus"].asString,
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
                currentProduct.value = ProductDetailDto(
                    res.data.asJsonObject["productDetailDto"].asJsonObject["certificationFailedReason"]?.toString(),
                    res.data.asJsonObject["productDetailDto"].asJsonObject["certificationStatus"]?.asString,
                    res.data.asJsonObject["productDetailDto"].asJsonObject["description"].asString,
                    res.data.asJsonObject["productDetailDto"].asJsonObject["fileList"].asJsonArray,
                    res.data.asJsonObject["productDetailDto"].asJsonObject["id"].asInt,
                    res.data.asJsonObject["productDetailDto"].asJsonObject["name"].asString,
                    res.data.asJsonObject["productDetailDto"].asJsonObject["price"].asInt,
                    res.data.asJsonObject["productDetailDto"].asJsonObject["productGrade"].asString,
                    res.data.asJsonObject["productDetailDto"].asJsonObject["useStatus"].asString,
                    res.data.asJsonObject["productDetailDto"].asJsonObject["salesStatus"].asString,
                    ProductDetailDto.UserShowResponse(res.data.asJsonObject["userShowResponse"].asJsonObject["name"].asString,
                        res.data.asJsonObject["userShowResponse"].asJsonObject["phoneNumber"].asString)
                )
            }
        })
    }

}