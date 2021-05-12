package com.example.garam.jeongoo.util

import android.content.Intent
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.RecyclerAdapter
import com.example.garam.jeongoo.data.ProductDetailDto
import com.example.garam.jeongoo.home.main.ProductInfoActivity

object DataBindingUtils {

    @BindingAdapter("itemList")
    @JvmStatic
    fun bindItem(recyclerView: RecyclerView, items: ObservableArrayList<ProductDetailDto>) {
        if(recyclerView.adapter == null) {
            val lm = LinearLayoutManager(recyclerView.context)
            val adapter = RecyclerAdapter()
            recyclerView.layoutManager = lm
            recyclerView.adapter = adapter
        }
        (recyclerView.adapter as RecyclerAdapter).items = items
        recyclerView.adapter?.notifyDataSetChanged()
    }

//    @BindingAdapter("recyclerOnclick")
//    @JvmStatic
//    fun onClick(recyclerView: RecyclerView,id: Int) {
//        recyclerView.setOnClickListener {
//            val nextIntent = Intent(recyclerView.context,ProductInfoActivity::class.java)
//            nextIntent.putExtra("productId",id)
//            recyclerView.context.startActivity(nextIntent)
//        }
//    }

    @BindingAdapter("loadAlbumImage")
    @JvmStatic
    fun setAlbumImage(imageView: ImageView, url: String?){
        Glide.with(imageView.context).load(url).centerInside().error(R.drawable.ic_launcher_foreground).into(imageView)
    }
}