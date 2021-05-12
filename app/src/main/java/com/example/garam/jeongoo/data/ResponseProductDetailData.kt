package com.example.garam.jeongoo.data

import com.google.gson.JsonObject

data class ResponseProductDetailData(
    val data : JsonObject,
    val message : String,
    val statusCode : Int
)
