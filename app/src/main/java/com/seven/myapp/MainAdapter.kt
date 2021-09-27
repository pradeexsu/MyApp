package com.seven.myapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.seven.myapp.databinding.*
import com.seven.myapp.response.HomeBannersResponse

class MainAdapter(
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var banners = listOf(
        HomeBannersResponse.HomeBannersResponseItem(text = "ban rect", type = "rect"),
        HomeBannersResponse.HomeBannersResponseItem(text = "mic line", type = "line"),
        HomeBannersResponse.HomeBannersResponseItem(text = "ten strip", type = "strip"),
        HomeBannersResponse.HomeBannersResponseItem(text = "mic line", type = "line"),
        HomeBannersResponse.HomeBannersResponseItem(text = "doc square", type = "square"),
        HomeBannersResponse.HomeBannersResponseItem(text = "mic line", type = "line")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            SQUARE_BANNER -> SquareBannerViewHolder(
                ItemSquareBannerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )
            RECTANGULAR_BANNER -> RectangularBannerViewHolder(
                ItemRectangularBannerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )
            STRIP_BANNER -> StripBannerViewHolder(
                ItemStripBannerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )
            LINE_BANNER -> SepratorLineViewHolder(
                ItemLineSepratorBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )
            COVER_BANNER -> CoverBannerViewHolder(
                ItemCoverBannerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )
            else -> SepratorLineViewHolder(
                ItemLineSepratorBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )

        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            SQUARE_BANNER -> (holder as SquareBannerViewHolder).bind(banners[position], position)
            RECTANGULAR_BANNER -> (holder as RectangularBannerViewHolder).bind(
                banners[position],
                position
            )
            STRIP_BANNER -> (holder as StripBannerViewHolder).bind(banners[position], position)
            LINE_BANNER -> (holder as SepratorLineViewHolder).bind(banners[position], position)
            COVER_BANNER -> (holder as CoverBannerViewHolder).bind(banners[position], position)
            else -> (holder as SepratorLineViewHolder).bind(banners[position], position)

        }
    }

    override fun getItemCount(): Int {
        return banners.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (banners[position].type) {
            "square" -> SQUARE_BANNER
            "rect" -> RECTANGULAR_BANNER
            "strip" -> STRIP_BANNER
            "line" -> LINE_BANNER
            "cover" -> COVER_BANNER
            else -> LINE_BANNER

        }
    }

    fun setData(list: List<HomeBannersResponse.HomeBannersResponseItem>) {
        banners = list
        notifyDataSetChanged()              /// <----cat
    }

    class RectangularBannerViewHolder(private val binding: ItemRectangularBannerBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
                Toast.makeText(context, banner.img,Toast.LENGTH_LONG)
            banner.img?.let {
                Glide.with(context).load(it).into(background)
            }
        }

    }
    class CoverBannerViewHolder(private val binding: ItemCoverBannerBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
            Toast.makeText(context, banner.img, Toast.LENGTH_LONG)
            banner.img?.let {
                Glide.with(context).load(it).into(background)
            }
        }
    }
        class SquareBannerViewHolder(private val binding: ItemSquareBannerBinding,private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
//        var text = binding.tvText
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
//            text.text = banner.text
            Toast.makeText(context, banner.img,Toast.LENGTH_LONG)
            banner.img?.let {
                Glide.with(context).load(it).into(background)

            }
        }

    }

    class StripBannerViewHolder(private val binding: ItemStripBannerBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
//        var text = binding.tvText
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
//            text.text = banner.text
            Toast.makeText(context, banner.img,Toast.LENGTH_LONG)
            banner.img?.let {

                Glide.with(context).load(it).into(background)
            }
        }

    }

    class SepratorLineViewHolder(private val binding: ItemLineSepratorBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
            Toast.makeText(context, banner.img,Toast.LENGTH_LONG)
            banner.img?.let {

                Glide.with(context).load(it).into(background)
            }
        }
    }


}