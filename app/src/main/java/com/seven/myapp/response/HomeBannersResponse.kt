package com.seven.myapp.response


import com.google.gson.annotations.SerializedName

class HomeBannersResponse : ArrayList<HomeBannersResponse.HomeBannersResponseItem>(){
    data class HomeBannersResponseItem(
        @SerializedName("color")
        val color: String?=null,
        @SerializedName("img")
        val img: String?=null,
        @SerializedName("text")
        val text: String,
        @SerializedName("type")
        val type: String
    )
}