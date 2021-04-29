package com.example.garam.jeongoo.network

import com.example.garam.jeongoo.data.ProductInfoData
import com.example.garam.jeongoo.data.SignInData
import com.example.garam.jeongoo.data.SignUpInfoData
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @GET("/v2/local/search/address.json")
    fun address(
        @Header("Authorization") key: String,
        @Query("query") query: String
    ): Call<JsonObject>

    @POST("/api/v1/users/signup")
    fun signUp(
        @Body signUpInfo : SignUpInfoData
    ) : Call<ResponseBody>

    @POST("/api/v1/users/signin")
    fun signIn(
        @Body signInInfo : SignInData
    ) : Call<ResponseBody>

    @POST("/api/v1/products/users/{userId}")
    fun productEnroll(
        @Body productInfoData: ProductInfoData
    ) : Call<ResponseBody>

    @DELETE("v1/{id}")
    fun productDelete(
        @Path("id") id : Long
    ) : Call<ResponseBody>



}