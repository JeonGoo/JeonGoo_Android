package com.example.garam.jeongoo.viewModel

import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.garam.jeongoo.BuildConfig
import com.example.garam.jeongoo.HomeActivity
import com.example.garam.jeongoo.PreferenceManager
import com.example.garam.jeongoo.SignUpActivity
import com.example.garam.jeongoo.data.AddressDto
import com.example.garam.jeongoo.data.SignInData
import com.example.garam.jeongoo.data.SignUpInfoData
import com.example.garam.jeongoo.network.KakaoMap
import com.example.garam.jeongoo.network.NetworkController
import com.example.garam.jeongoo.network.NetworkService
import com.google.gson.JsonObject
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
    private val context = getApplication<Application>().applicationContext
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
        networkService.signIn(signIn).enqueue(object : Callback<JsonObject>{
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {

            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                if(response.body() != null) {
                    val res = response.body()!!
                    val data = res["data"].asJsonObject

                    val preferenceManager = PreferenceManager()

                    val id = data["id"].asInt
                    val token = data["token"].asString

                    Log.e("id : ",id.toString())
                    Log.e("token : ",token)

                    preferenceManager.setToken(context,"token",token)
                    preferenceManager.setId(context,"userId",id)

                    val intent = Intent(context,HomeActivity::class.java)
                    context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                }

            }

        })

    }

    fun signUpActivity() {
        val intent = Intent(context,SignUpActivity::class.java)
        context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }

    fun setOnclickSignUp() {

        val address = AddressDto(customerCityAddress.value.toString(),
        customerDetailAddress.value.toString())

        signUp(SignUpInfoData(address,customerEmail.value.toString(),customerPassword.value.toString(),
        customerName.value.toString(),"MALE", customerPhoneNumber.value.toString()))
    }

    private fun signUp(signUp : SignUpInfoData) {
        networkService.signUp(signUp).enqueue(object : Callback<JsonObject>{
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {

            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if(response.body()!!["message"].toString() == "회원 가입 성공") {
                    Toast.makeText(context,"회원 가입에 성공했습니다",Toast.LENGTH_SHORT).show()

                }
            }

        })
    }

    fun findAddress() {

        networkApi.address(BuildConfig.KakaoKey,customerCityAddress.value.toString()).enqueue(
            object : Callback<JsonObject> {
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                }

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    val res = response.body()
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