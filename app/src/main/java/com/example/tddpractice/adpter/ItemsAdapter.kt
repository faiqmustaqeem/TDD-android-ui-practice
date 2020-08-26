package com.example.tddpractice.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tddpractice.databinding.RowItemBinding
import com.example.tddpractice.model.ItemModel

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private var list = emptyList<ItemModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemViewHolder =
        ItemViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.name.text = list[position].itemName
    }

    fun setData(list: List<ItemModel>) {
        this.list = list
        notifyDataSetChanged()
    }


    class ItemViewHolder(var binding: RowItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}