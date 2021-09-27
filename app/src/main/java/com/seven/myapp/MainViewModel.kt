package com.seven.myapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seven.myapp.response.HomeBannersResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var liveData = MutableLiveData<Response<List<HomeBannersResponse.HomeBannersResponseItem>>>()

    init {
        getBannersList()
    }
    fun getBannersList(){
        viewModelScope.launch{
            val response = repository.getBanners()
            liveData.value = response
        }
    }


}