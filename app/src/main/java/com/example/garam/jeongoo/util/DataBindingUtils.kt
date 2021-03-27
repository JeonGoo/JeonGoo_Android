package com.example.garam.jeongoo.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.RecyclerAdapter
import com.example.garam.jeongoo.data.ProductInfoData

object DataBindingUtils {

    @BindingAdapter("itemList")
    @JvmStatic
    fun bindItem(recyclerView: RecyclerView, items: ObservableArrayList<ProductInfoData>) {
        if(recyclerView.adapter == null) {
            val lm = LinearLayoutManager(recyclerView.context)
            val adapter = RecyclerAdapter()
            recyclerView.layoutManager = lm
            recyclerView.adapter = adapter
        }
        (recyclerView.adapter as RecyclerAdapter).items = items
        recyclerView.adapter?.notifyDataSetChanged()
    }


    @BindingAdapter("loadAlbumImage")
    @JvmStatic
    fun setAlbumImage(imageView: ImageView, url: String?){
        Glide.with(imageView.context).load(url).centerInside().error(R.drawable.ic_launcher_foreground).into(imageView)
    }
}