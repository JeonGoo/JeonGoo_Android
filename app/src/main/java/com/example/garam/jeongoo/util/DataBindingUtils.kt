package com.example.garam.jeongoo.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.garam.jeongoo.R

object DataBindingUtils {

    @BindingAdapter("loadAlbumImage")
    @JvmStatic
    fun setAlbumImage(imageView: ImageView, url: String?){
        Glide.with(imageView.context).load(url).centerInside().error(R.drawable.ic_launcher_foreground).into(imageView)
    }
}