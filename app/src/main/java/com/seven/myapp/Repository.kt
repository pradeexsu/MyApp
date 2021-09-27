package com.seven.myapp

import com.seven.myapp.response.HomeBannersResponse.*
import retrofit2.Response

class Repository {
    suspend fun getBanners():Response<List<HomeBannersResponseItem>> {
        // Your Api Call with response callback
        return RetrofitInstance.api.getBanners()
    }
}
