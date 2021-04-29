package com.example.garam.jeongoo.data

data class SignUpInfoData(
    val addressDto: AddressDto,
    val email : String,
    val password : String,
    val name : String,
    val gender : String,
    val phoneNumber : String
)
