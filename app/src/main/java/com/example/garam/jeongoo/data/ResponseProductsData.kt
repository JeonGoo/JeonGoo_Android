package com.example.garam.jeongoo.data

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class ResponseProductsData(
    val data : JsonArray,
    val message : String,
    val statusCode : Int
)
