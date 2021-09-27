package com.seven.myapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: APIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/sutharp777/projects/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}