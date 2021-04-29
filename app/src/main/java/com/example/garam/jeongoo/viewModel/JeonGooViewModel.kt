package com.example.garam.jeongoo.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.garam.jeongoo.BuildConfig
import com.example.garam.jeongoo.data.AddressDto
import com.example.garam.jeongoo.data.SignInData
import com.example.garam.jeongoo.data.SignUpInfoData
import com.example.garam.jeongoo.network.KakaoMap
import com.example.garam.jeongoo.network.NetworkController
import com.example.garam.jeongoo.network.NetworkService
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JeonGooViewModel(application: Application) : AndroidViewModel(application) {

    private val networkService : NetworkService by lazy {
        NetworkController.instance.networkService
    }
    private val retrofit : Retrofit = Retrofit.Builder().baseUrl(KakaoMap.instance.kakaoURL)
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val networkApi = retrofit.create(NetworkService::class.java)


    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val customerEmail = MutableLiveData<String>()
    val customerName = MutableLiveData<String>()
    val customerCityAddress = MutableLiveData<String>().apply {
        value = ""
    }
    val customerDetailAddress = MutableLiveData<String>()
    val customerGender = MutableLiveData<String>()
    val customerPhoneNumber = MutableLiveData<String>()
    val customerPassword = MutableLiveData<String>()

    fun setOnClickSignIn() {
        signIn(SignInData(email.value.toString(),password.value.toString()))
    }

    private fun signIn(signIn : SignInData) {
        networkService.signIn(signIn).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

            }

        })

    }

    fun setOnclickSignUp() {

        val address = AddressDto(customerCityAddress.value.toString(),
        customerDetailAddress.value.toString())

        signUp(SignUpInfoData(address,customerEmail.value.toString(),customerPassword.value.toString(),
        customerName.value.toString(),"MALE", customerPhoneNumber.value.toString()))
    }

    private fun signUp(signUp : SignUpInfoData) {
        networkService.signUp(signUp).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

            }

        })
    }

    fun findAddress() {

        Log.e("address",customerCityAddress.value)

        networkApi.address(BuildConfig.KakaoKey,customerCityAddress.value.toString()).enqueue(
            object : Callback<JsonObject> {
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    Log.e("???",t.message)
                }

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    val res = response.body()
                    Log.e("fadfa",res.toString())
                    val documents = res?.getAsJsonArray("documents")
                    val meta = res?.getAsJsonObject("meta")
                    val totalCount = meta?.get("total_count")?.asInt
                    if (totalCount == 1) {
                        val add = documents?.asJsonArray?.get(0)
                        val addInfo = add?.asJsonObject?.get("address")
                        when {
                            addInfo != null -> {
                                val addressName = JSONObject(addInfo.toString()).getString("address_name")

                                customerCityAddress.value = addressName
                            }
                        }
                    }

                }
            })

    }

}