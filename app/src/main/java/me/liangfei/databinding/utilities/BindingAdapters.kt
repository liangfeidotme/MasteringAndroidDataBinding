package me.liangfei.databinding.utilities

import android.graphics.BitmapFactory
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


object BindingAdapters {
    @JvmStatic
    @BindingAdapter(value = ["url", "isRounded"], requireAll = false)
    fun loadImage(imageView: ImageView, url: String?, isRounded: Boolean = false) {
        Glide.with(imageView)
                .load(url)
                .apply(
                        if (isRounded) RequestOptions.circleCropTransform()
                        else RequestOptions.noTransformation()
                )
                .into(imageView)
    }

    @JvmStatic
    @BindingAdapter(value = ["avatarFromAssets"])
    fun loadAssetImage(imageView: ImageView, filePath: String) {
        with (imageView.context) {
            Glide.with(this)
                    .load(BitmapFactory.decodeStream(assets.open(filePath)))
                    .apply(RequestOptions.circleCropTransform())
                    .into(imageView)
        }
    }
}