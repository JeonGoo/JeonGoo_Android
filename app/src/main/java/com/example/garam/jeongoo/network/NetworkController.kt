package com.example.garam.jeongoo.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkController : Application() {
    private val baseUrl = "http://15.164.90.61:8080"

    lateinit var networkService : NetworkService

    companion object {
        lateinit var instance : NetworkController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }
    private fun buildNetwork() {
        val retrofit : Retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
            GsonConverterFactory.create()).build()

        networkService = retrofit.create(NetworkService::class.java)
    }
}