package com.example.garam.jeongoo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.garam.jeongoo.data.ProductInfoData
import com.example.garam.jeongoo.databinding.ItemListLayoutBinding

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var items = ArrayList<ProductInfoData>()

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
        fun bind(item: ProductInfoData ) {
            binding.itemInfo = item
        }
    }
}