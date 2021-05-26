package com.example.garam.jeongoo.data

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName

data class ProductDetailDto(

    @SerializedName("certificationFailedReason") val certificationFailedReason : String?,
    @SerializedName("certificationStatus") val certificationStatus : String?,
    @SerializedName("description") val description : String,
    @SerializedName("fileList") val fileList : JsonArray?,
    @SerializedName("id") val id : Int,
    @SerializedName("hitCount") val hitCount : Int,
    @SerializedName("name") val name : String,
    @SerializedName("price") val price : Int,
    @SerializedName("productGrade") val productGrade : String,
    @SerializedName("useStatus") val useStatus : String,
    @SerializedName("salesStatus") val salesStatus : String,
    @SerializedName("userShowResponse") val sellerInfo : UserShowResponse
)
{
    data class UserShowResponse(
        val name: String,
        val phoneNumber : String
    )
}
