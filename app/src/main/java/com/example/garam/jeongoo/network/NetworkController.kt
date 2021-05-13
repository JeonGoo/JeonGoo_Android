package com.example.garam.jeongoo.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkController : Application() {
    private val baseUrl = "https://d0ef076b106b.ngrok.io"

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