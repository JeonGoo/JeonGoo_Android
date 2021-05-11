package com.example.garam.jeongoo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.garam.jeongoo.data.ProductDetailDto
import com.example.garam.jeongoo.databinding.ItemListLayoutBinding

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var items = ArrayList<ProductDetailDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: ItemListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductDetailDto ) {
            Log.e("???",item.name)
            binding.itemInfo = item
        }
    }
}