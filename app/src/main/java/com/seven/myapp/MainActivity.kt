package com.seven.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


import com.seven.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = MainAdapter(this)
        binding.rvList.adapter = adapter


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository = repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getBannersList()
        viewModel.liveData.observe(this, Observer { response->
            if(response.isSuccessful){
                Toast.makeText(this,"success to fetch data",Toast.LENGTH_LONG).show()
                response.body()?.let {
                adapter.setData(it)
                }
            }
            else{
                Toast.makeText(this,"failed to fetch data",Toast.LENGTH_LONG).show()

            }
        })
    }
}