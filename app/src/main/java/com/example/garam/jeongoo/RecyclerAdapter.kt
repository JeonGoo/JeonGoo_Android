package com.example.garam.jeongoo

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.garam.jeongoo.data.ProductDetailDto
import com.example.garam.jeongoo.databinding.ItemListLayoutBinding
import com.example.garam.jeongoo.home.main.ProductInfoActivity

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
            binding.itemInfo = item

            binding.root.setOnClickListener {
                val nextIntent = Intent(binding.root.context,ProductInfoActivity::class.java)
                nextIntent.putExtra("productId",item.id)
                binding.root.context.startActivity(nextIntent)
            }
        }
    }
}