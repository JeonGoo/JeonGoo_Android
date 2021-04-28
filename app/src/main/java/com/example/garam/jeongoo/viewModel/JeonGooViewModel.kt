package com.example.garam.jeongoo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.garam.jeongoo.data.SignInData
import com.example.garam.jeongoo.data.SignUpInfoData
import com.example.garam.jeongoo.network.KakaoMap
import com.example.garam.jeongoo.network.NetworkController
import com.example.garam.jeongoo.network.NetworkService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JeonGooViewModel(application: Application) : AndroidViewModel(application) {

    private val networkService : NetworkService by lazy {
        NetworkController.instance.networkService
    }

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val customerEmail = MutableLiveData<String>()
    val customerName = MutableLiveData<String>()
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
        signUp(SignUpInfoData(customerEmail.value.toString(),customerPassword.value.toString(),
        customerName.value.toString(),customerGender.value.toString(), customerPhoneNumber.value.toString()))
    }

    private fun signUp(signUp : SignUpInfoData) {
        networkService.signUp(signUp).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

            }

        })
    }

}