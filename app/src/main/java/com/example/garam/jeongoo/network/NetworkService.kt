package com.example.garam.jeongoo.network

import com.example.garam.jeongoo.data.ProductInfoData
import com.example.garam.jeongoo.data.SignInData
import com.example.garam.jeongoo.data.SignUpInfoData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @POST("/v1/signup")
    fun signUp(
        @Body signUpInfo : SignUpInfoData
    ) : Call<ResponseBody>

    @POST("/v1/signin")
    fun signIn(
        @Body signInInfo : SignInData
    ) : Call<ResponseBody>

    @POST("/v1")
    fun productEnroll(
        @Body productInfoData: ProductInfoData
    ) : Call<ResponseBody>

    @DELETE("v1/{id}")
    fun productDelete(
        @Path("id") id : Long
    ) : Call<ResponseBody>
}