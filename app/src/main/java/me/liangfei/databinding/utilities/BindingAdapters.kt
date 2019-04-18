package me.liangfei.databinding.utilities

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import me.liangfei.databinding.R


object BindingAdapters {
    @JvmStatic
    @BindingAdapter("url")
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView)
                .load(url)
                .centerCrop()
//                .placeholder(android.R.drawable)
                .into(imageView)
    }
}