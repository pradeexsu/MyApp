package com.seven.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


import com.seven.myapp.databinding.ActivityMainBinding
import com.seven.myapp.response.HomeBannersResponse

class MainActivity : AppCompatActivity(),
    MainAdapter.SquareBannerViewHolder.ItemClickedSquare,
    MainAdapter.RectangularBannerViewHolder.ItemClickedRect,
    MainAdapter.TextViewHolder.TextViewClicked,
    MainAdapter.ImageViewHolder.ItemImageClicked,
    MainAdapter.SuperUserViewHolder.ItemClickedSuperUser,
    MainAdapter.CoverBannerViewHolder.ItemClickedCover,
    MainAdapter.UserViewHolder.ItemClickedUser,
    MainAdapter.StripBannerViewHolder.ItemClickedStrip {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = MainAdapter(this,this, this,
            this, this, this, this,
            this, this)

        binding.rvList.adapter = adapter


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository = repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getBannersList()
        viewModel.liveData.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Toast.makeText(this, "success to fetch data", Toast.LENGTH_LONG).show()
                response.body()?.let {
                    adapter.setData(it as ArrayList<HomeBannersResponse.HomeBannersResponseItem>)
                }
            } else {
                Toast.makeText(this, "failed to fetch data", Toast.LENGTH_LONG).show()

            }
        })
    }

    override fun itemClickedRect(view: View) {
        Toast.makeText(this,"Rectangle Clicked",Toast.LENGTH_LONG).show()
    }

    override fun itemClickedCover(view: View) {
        Toast.makeText(this,"Cover View Clicked",Toast.LENGTH_LONG).show()
    }

    override fun itemClickedSquare(view: View) {
        Toast.makeText(this,"Square Clicked",Toast.LENGTH_LONG).show()
    }

    override fun itemClickedStrip(view: View) {
        Toast.makeText(this,"Strip Clicked",Toast.LENGTH_LONG).show()
    }

    override fun itemClickedUser(view: View) {
        Toast.makeText(this,"User Clicked",Toast.LENGTH_LONG).show()
    }

    override fun itemClickedSuperUser(view: View) {
        Toast.makeText(this,"Super User Clicked",Toast.LENGTH_LONG).show()
    }

    override fun itemImageClicked(view: View) {
        Toast.makeText(this,"Image Clicked",Toast.LENGTH_LONG).show()
    }

    override fun textViewClicked(view: View) {
        Toast.makeText(this,"Text Clicked",Toast.LENGTH_LONG).show()
    }
}