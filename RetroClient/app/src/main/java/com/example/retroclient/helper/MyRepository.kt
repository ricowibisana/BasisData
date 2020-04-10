package com.example.retroclient.helper

import com.example.retroclient.custom.MyServices
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRepository {
    fun create(): MyServices {
        val retro = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/*")
            .build()
        return retro.create(MyServices::class.java)
    }
}