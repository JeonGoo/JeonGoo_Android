package com.example.garam.jeongoo.data

import okhttp3.MultipartBody

data class ProductBasicInfoRequest(
    val name : String,
    val serialNumber : String,
    val useStatus: String,
    val description : String,
    val price : Int
) {
    data class FileInfoRequest(
        val imageFiles : ArrayList<MultipartBody.Part?>?
    )
}
