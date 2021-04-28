package com.example.garam.jeongoo.data

import com.google.gson.JsonObject

data class ResponseProductsData(
    val certificationFailedReason : String,
    val certificationStatus : String,
    val description : String,
    val fileList : ArrayList<JsonObject>,
    val id : Long,
    val name : String,
    val price : JsonObject,
    val productGrade : String,
    val useStatus : String
)
