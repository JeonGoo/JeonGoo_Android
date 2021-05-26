package com.example.garam.jeongoo.util

import android.content.Intent
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.garam.jeongoo.PreferenceManager
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.RecyclerAdapter
import com.example.garam.jeongoo.data.ProductDetailDto
import com.example.garam.jeongoo.home.myInfo.InterestedActivity
import com.example.garam.jeongoo.home.myInfo.PurchasedListActivity
import com.example.garam.jeongoo.home.myInfo.SaleListActivity
import com.example.garam.jeongoo.network.NetworkController
import com.example.garam.jeongoo.network.NetworkService
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataBindingUtils {

    private val networkService : NetworkService by lazy {
        NetworkController.instance.networkService
    }

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

    @BindingAdapter("saleList")
    @JvmStatic
    fun saleList(imageView: ImageView, userId: Int) {
        val nextIntent = Intent(imageView.context,SaleListActivity::class.java)
        imageView.context.startActivity(nextIntent)
    }

    @BindingAdapter("purchasedList")
    @JvmStatic
    fun purchasedList(imageView: ImageView, userId: Int){
        val nextIntent = Intent(imageView.context, PurchasedListActivity::class.java)
        imageView.context.startActivity(nextIntent)
    }

    @BindingAdapter("interestedList")
    @JvmStatic
    fun interestedList(imageView: ImageView, userId: Int){
        val nextIntent = Intent(imageView.context, InterestedActivity::class.java)
        imageView.context.startActivity(nextIntent)
    }

    @BindingAdapter("loadPreviewImage")
    @JvmStatic
    fun setPreviewImage(imageView: ImageView, url: String?){
        Glide.with(imageView.context).load(url).centerInside().error(R.drawable.ic_launcher_foreground).into(imageView)
    }

    @BindingAdapter("setInterest")
    @JvmStatic
    fun setInterest(imageButton: ImageButton, productId : Int) {

        val preferenceManager = PreferenceManager()
        val userId = preferenceManager.getId(imageButton.context,"userId")

        Log.e("fda",userId.toString())

        imageButton.setOnClickListener {
            if(!imageButton.isSelected) {
                imageButton.isSelected = true

                networkService.registerInterestProduct(productId, userId).enqueue(object : Callback<JsonObject> {
                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                    }
                })
            }
            else {
                imageButton.isSelected = false
                networkService.deleteInterest(productId,userId).enqueue(object : Callback<JsonObject>{
                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                    }
                })
            }
        }
    }
}