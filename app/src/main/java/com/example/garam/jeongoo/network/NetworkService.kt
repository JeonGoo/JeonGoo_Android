package com.example.garam.jeongoo.network

import com.example.garam.jeongoo.data.*
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.io.File

interface NetworkService {

    @GET("/v2/local/search/address.json")
    fun address(
        @Header("Authorization") key: String,
        @Query("query") query: String
    ): Call<JsonObject>

    @POST("/api/v1/users/signup")
    fun signUp(
        @Body signUpInfo : SignUpInfoData
    ) : Call<JsonObject>

    @POST("/api/v1/users/signin")
    fun signIn(
        @Body signInInfo : SignInData
    ) : Call<JsonObject>

    @POST("/api/v1/products/{productId}/purchase/{userId}")
    fun purchase(
        @Path("productId") productId : Int,
        @Path("userId") userId : Int
    ) : Call<JsonObject>

    @Multipart
    @POST("/api/v1/products/users/{userId}")
    fun productRegister(
        @Part imageFiles : MultipartBody.Part?,
        @Part videoFile : MultipartBody.Part?,
        @Path ("userId") userId: Int,
        @Part description : MultipartBody.Part,
        @Part name : MultipartBody.Part,
        @Part price : MultipartBody.Part,
        @Part serialNumber : MultipartBody.Part,
        @Part useStatus : MultipartBody.Part
    ) : Call<JsonObject>

    @DELETE("/api/v1/products/{productId}")
    fun productDelete(
        @Path("productId") id : Int
    ) : Call<JsonObject>

    @PUT("/api/v1/users/{userId}")
    fun userUpdate(
        @Body updateRequest : JsonObject,
        @Path("userId") userId : Int
    ) : Call<JsonObject>

    @GET("/api/v1/products")
    fun findAllProduct(
        @Query("page") page : Int?,
        @Query("size") size : Int?,
        @Query("sort") sort : ArrayList<String>?
    ) : Call<ResponseProductsData>

    @GET("/api/v1/products/{productId}")
    fun findProduct(
        @Path("productId") id : Int
    ) : Call<ResponseProductDetailData>

    @GET("/api/v1/purchased/products")
    fun allPurchasedProducts() : Call<ResponseProductsData>

    @GET("/api/v1/purchased/products/users/{userId}/purchased")
    fun purchasedProducts(
        @Path ("userId") userId: Int
    ) : Call<ResponseProductsData>

    @GET("/api/v1/purchased/products/users/{userId}/sell")
    fun sellProducts(
        @Path ("userId") userId: Int
    ) : Call<ResponseProductsData>

    @GET("/api/v1/products/users/{userId}")
    fun userEnrollProduct(
        @Path ("userId") userId : Int
    )  : Call<ResponseProductsData>

    @POST("/api/v1/interest/products/{productId}/users/{userId}")
    fun registerInterestProduct(
        @Path("productId") productId: Int,
        @Path("userId") userId: Int
    ): Call<JsonObject>

    @GET("/api/v1/interest/products/users/{interestedUserId}")
    fun findInterestProduct(
        @Path("interestedUserId") userId: Int
    ) : Call<ResponseProductsData>

    @DELETE("/api/v1/interest/products/registered/products/{productId}/users/{interestedUserId}")
    fun deleteInterest(
        @Path ("productId") productId: Int,
        @Path ("interestedUserId") userId : Int
    ) : Call<JsonObject>
}