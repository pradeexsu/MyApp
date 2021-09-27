package com.seven.myapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.seven.myapp.databinding.*
import com.seven.myapp.response.HomeBannersResponse

class MainAdapter(
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var banners = ArrayList<HomeBannersResponse.HomeBannersResponseItem>()

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
            LINE_BANNER -> SeparatorLineViewHolder(
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
            USER_BANNER -> UserViewHolder(
                ItemUserProfileBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )
            SUPER_BANNER -> SuperUserViewHolder(
                ItemSuperUserProfileBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )
            TEXT_BANNER -> TextViewHolder(
                ItemTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )
            IMAGE_BANNER -> ImageViewHolder(
                ItemImageBannerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )
            NA_BANNER -> NaViewHolder(
                ItemNaBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), context
            )
            else -> NaViewHolder(
                ItemNaBinding.inflate(
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
            LINE_BANNER -> (holder as SeparatorLineViewHolder).bind(banners[position], position)
            COVER_BANNER -> (holder as CoverBannerViewHolder).bind(banners[position], position)
            USER_BANNER -> (holder as UserViewHolder).bind(banners[position], position)
            SUPER_BANNER -> (holder as SuperUserViewHolder).bind(banners[position], position)
            TEXT_BANNER -> (holder as TextViewHolder).bind(banners[position], position)
            IMAGE_BANNER -> (holder as ImageViewHolder).bind(banners[position], position)
            NA_BANNER -> (holder as NaViewHolder).bind(banners[position], position)
            else -> (holder as NaViewHolder).bind(banners[position], position)

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
            "user" -> USER_BANNER
            "super" -> SUPER_BANNER
            "text" -> TEXT_BANNER
            "image" -> IMAGE_BANNER
            else -> NA_BANNER
        }
    }

    fun setData(list: ArrayList<HomeBannersResponse.HomeBannersResponseItem>) {
        banners = list
        notifyDataSetChanged()              /// <----cat
    }

    class RectangularBannerViewHolder(private val binding: ItemRectangularBannerBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
            banner.img?.let {
                Glide.with(context).load(it).into(background)
            }
        }

    }
    class CoverBannerViewHolder(private val binding: ItemCoverBannerBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
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
            banner.img?.let {

                Glide.with(context).load(it).into(background)
            }
        }

    }

    class SeparatorLineViewHolder(private val binding: ItemLineSepratorBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
            banner.img?.let {
                Glide.with(context).load(it).into(background)
            }
        }
    }

    class UserViewHolder(private val binding: ItemUserProfileBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var dp = binding.profileImage
        var username = binding.username
        var bio = binding.bio

        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
            banner.img?.let {
                Glide.with(context).load(it).into(dp)
            }
            username.text = banner.text
            bio.text = banner.color
        }
    }
    class SuperUserViewHolder(private val binding: ItemSuperUserProfileBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var dp = binding.profileImage
        var username = binding.username
        var bio = binding.bio

        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
            banner.img?.let {
                Glide.with(context).load(it).into(dp)
            }
            username.text = banner.text
            bio.text = banner.color
        }
    }

    class ImageViewHolder(private val binding: ItemImageBannerBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var img = binding.ivImage

        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
            banner.img?.let {
                Glide.with(context).load(it).into(img)
            }
        }
    }

    class TextViewHolder(private val binding: ItemTextBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var textView = binding.tvText

        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
            textView.text = banner.text
        }
    }

    class NaViewHolder(private val binding: ItemNaBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, pos: Int) {
        }
    }



}