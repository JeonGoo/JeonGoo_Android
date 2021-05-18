package com.example.garam.jeongoo.network

import com.example.garam.jeongoo.data.*
import com.google.gson.JsonObject
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

    @POST("/api/v1/products/users/{userId}")
    fun productEnroll(
        @Header("Authorization") token : String,
        @Body productInfoData: ProductRequest,
        @Path ("userId") userId: Int
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
    fun findAllProduct() : Call<ResponseProductsData>

    @GET("/api/v1/products/{productId}")
    fun findProduct(
        @Path("productId") id : Int
    ) : Call<ResponseProductDetailData>

    @GET("/api/v1/products/users/{userId}")
    fun salesList(
        @Path("userId") id : Int
    ) : Call<ResponseProductsData>

    @GET("api/v1/purchased/products")
    fun allPurchasedProducts() : Call<ResponseProductsData>

    @GET("api/v1/purchased/products/users/{userId}/purchased")
    fun purchasedProducts() : Call<ResponseProductsData>

    @GET("api/v1/purchased/products/users/{userId}/sell")
    fun sellProducts() : Call<ResponseProductsData>

    @POST("api/v1/interest/products/{productId}/users/{usersId}")
    fun registerInterestProduct(
        @Path("productId") productId: Int,
        @Path("userId") userId: Int
    ): Call<JsonObject>


}