package com.seven.myapp

import com.seven.myapp.response.HomeBannersResponse
import retrofit2.Response
import retrofit2.http.GET


const val GET_VIEW_TYPE_API = "api/api.json"
interface APIService {

        @GET(GET_VIEW_TYPE_API)
        suspend fun getBanners(): Response<List<HomeBannersResponse.HomeBannersResponseItem>>

}