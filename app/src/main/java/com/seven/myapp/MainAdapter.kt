package com.seven.myapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.seven.myapp.databinding.*
import com.seven.myapp.response.HomeBannersResponse

class MainAdapter(
    val context: Context,
    private var clickedSquare: SquareBannerViewHolder.ItemClickedSquare,
    private var clickedRect: RectangularBannerViewHolder.ItemClickedRect,
    private var textClicked: TextViewHolder.TextViewClicked,
    private var imageClicked: ImageViewHolder.ItemImageClicked,
    private var clickedSuperUser: SuperUserViewHolder.ItemClickedSuperUser,
    private var clickedCover: CoverBannerViewHolder.ItemClickedCover,
    private var clickedUser: UserViewHolder.ItemClickedUser,
    private var clickedStrip: StripBannerViewHolder.ItemClickedStrip,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var banners = ArrayList<HomeBannersResponse.HomeBannersResponseItem>()

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
            SQUARE_BANNER -> (holder as SquareBannerViewHolder).bind(banners[position], clickedSquare)
            RECTANGULAR_BANNER -> (holder as RectangularBannerViewHolder).bind(banners[position], clickedRect)
            STRIP_BANNER -> (holder as StripBannerViewHolder).bind(banners[position], clickedStrip)
            LINE_BANNER -> (holder as SeparatorLineViewHolder).bind(banners[position])
            COVER_BANNER -> (holder as CoverBannerViewHolder).bind(banners[position], clickedCover)
            USER_BANNER -> (holder as UserViewHolder).bind(banners[position],clickedUser)
            SUPER_BANNER -> (holder as SuperUserViewHolder).bind(banners[position],clickedSuperUser)
            TEXT_BANNER -> (holder as TextViewHolder).bind(banners[position],textClicked)
            IMAGE_BANNER -> (holder as ImageViewHolder).bind(banners[position],imageClicked)
            NA_BANNER -> (holder as NaViewHolder).bind(banners[position])
            else -> (holder as NaViewHolder).bind(banners[position])

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

    class RectangularBannerViewHolder(
        private val binding: ItemRectangularBannerBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, itemClickListener: ItemClickedRect) {
            banner.img?.let {
                Glide.with(context).load(it).into(background)
            }
            binding.root.setOnClickListener {
                itemClickListener.itemClickedRect(it)
            }

        }

        interface ItemClickedRect {
            fun itemClickedRect(view: View)
        }
    }

    class CoverBannerViewHolder(
        private val binding: ItemCoverBannerBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, itemClickListener: ItemClickedCover) {
            banner.img?.let {
                Glide.with(context).load(it).into(background)
            }
            binding.root.setOnClickListener {
                itemClickListener.itemClickedCover(it)
            }


        }

        interface ItemClickedCover {
            fun itemClickedCover(view: View)
        }
    }

    class SquareBannerViewHolder(
        private val binding: ItemSquareBannerBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        //        var text = binding.tvText
//        var itemClickListner: ItemClickedSquare?=null
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, itemClickListener: ItemClickedSquare) {
//            text.text = banner.text
            binding.root.setOnClickListener {
                itemClickListener.itemClickedSquare(it)
            }
            banner.img?.let {
                Glide.with(context).load(it).into(background)
            }
        }

        interface ItemClickedSquare {
            fun itemClickedSquare(view: View)
        }

    }

    class StripBannerViewHolder(
        private val binding: ItemStripBannerBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        //        var text = binding.tvText
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, itemClickListener:ItemClickedStrip) {
//            text.text = banner.text
            banner.img?.let {

                Glide.with(context).load(it).into(background)
            }
            binding.root.setOnClickListener {
                itemClickListener.itemClickedStrip(it)
            }
        }

        interface ItemClickedStrip {
            fun itemClickedStrip(view: View)
        }

    }

    class SeparatorLineViewHolder(
        private val binding: ItemLineSepratorBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        var background = binding.ivAvatar
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem) {
            banner.img?.let {
                Glide.with(context).load(it).into(background)
            }
        }
    }

    class UserViewHolder(
        private val binding: ItemUserProfileBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        var dp = binding.profileImage
        var username = binding.username
        var bio = binding.bio

        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, itemClickListener:ItemClickedUser) {
            banner.img?.let {
                Glide.with(context).load(it).into(dp)
            }
            username.text = banner.text
            bio.text = banner.color
            binding.root.setOnClickListener {
                itemClickListener.itemClickedUser(it)
            }

        }

        interface ItemClickedUser {
            fun itemClickedUser(view: View)
        }

    }

    class SuperUserViewHolder(
        private val binding: ItemSuperUserProfileBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        var dp = binding.profileImage
        var username = binding.username
        var bio = binding.bio

        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, itemClickListener:ItemClickedSuperUser) {
            banner.img?.let {
                Glide.with(context).load(it).into(dp)
            }
            username.text = banner.text
            bio.text = banner.color
            binding.root.setOnClickListener {
                itemClickListener.itemClickedSuperUser(it)
            }

        }

        interface ItemClickedSuperUser {
            fun itemClickedSuperUser(view: View)
        }

    }

    class ImageViewHolder(
        private val binding: ItemImageBannerBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        var img = binding.ivImage

        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem, itemClickListener: ItemImageClicked) {
            banner.img?.let {
                Glide.with(context).load(it).into(img)
            }
            binding.root.setOnClickListener {
                itemClickListener.itemImageClicked(it)
            }

        }

        interface ItemImageClicked {
            fun itemImageClicked(view: View)
        }

    }

    class TextViewHolder(private val binding: ItemTextBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var textView = binding.tvText

        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem,itemClickListener:TextViewClicked) {
            textView.text = banner.text
            binding.root.setOnClickListener {
                itemClickListener.textViewClicked(it)
            }

        }

        interface TextViewClicked {
            fun textViewClicked(view: View)
        }
    }

    class NaViewHolder(private val binding: ItemNaBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: HomeBannersResponse.HomeBannersResponseItem) {
        }
    }


}