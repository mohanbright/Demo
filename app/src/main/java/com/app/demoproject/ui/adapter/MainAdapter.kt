package com.app.demoproject.ui.adapter

import android.R.attr.data
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.demoproject.R
import com.app.demoproject.dataModal.HomeDataModal
import com.app.demoproject.databinding.ItemProductsBinding
import java.util.*
import kotlin.Comparator


class MainAdapter(var productList:List<HomeDataModal>) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    class MyViewHolder(var binding: ItemProductsBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<ItemProductsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_products,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            binding.items =productList[position]
            binding.ivRecipe.setImageResource(productList[position].image)
        }
    }

    fun filterByName(products:List<HomeDataModal>){
        Collections.sort(products,
            Comparator { lhs, rhs -> lhs.name.compareTo(rhs.name) })
}

    @SuppressLint("NewApi")
    fun filterByPrice(products:List<HomeDataModal>){
        Collections.sort(products,
            Comparator { lhs, rhs -> rhs.price.compareTo(lhs.price) })
    }
}