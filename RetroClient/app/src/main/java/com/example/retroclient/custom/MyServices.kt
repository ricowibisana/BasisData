package com.example.retroclient.custom

import com.example.retroclient.model.MyModel
import retrofit2.Call
import retrofit2.http.GET

interface MyServices {
    @GET("posts")
    fun getPosts(): Call<List<MyModel>>
}