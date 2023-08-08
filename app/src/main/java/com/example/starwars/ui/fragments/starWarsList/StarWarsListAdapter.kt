package com.example.starwars.ui.fragments.starWarsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.auth.data.People
import com.example.starwars.databinding.ItemInformationBinding
import com.example.starwars.ui.fragments.starWarsList.data.StarWarsListData

class StarWarsListAdapter(
    private val onClickFavourite: (String, Boolean) -> Unit
) : PagingDataAdapter<People, StarWarsListViewHolder>(object : DiffUtil.ItemCallback<People>() {
    
    override fun areItemsTheSame(oldItem: People, newItem: People): Boolean {
        return oldItem.name == newItem.name
    }
    
    override fun areContentsTheSame(oldItem: People, newItem: People): Boolean {
        return oldItem == newItem
    }
}) {
    
    private val data = mutableListOf<StarWarsListData>()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarWarsListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemInformationBinding =
            ItemInformationBinding.inflate(layoutInflater, parent, false)
        return StarWarsListViewHolder(binding, onClickFavourite)
    }
    
    fun addData(dataTemp: List<StarWarsListData>) {
        val prevCount = data.size
        data.clear()
        notifyItemRangeRemoved(0, prevCount)
        data.addAll(dataTemp)
        notifyItemRangeInserted(0, dataTemp.size)
    }
    
//    override fun getItemCount() = data.size
    
    override fun onBindViewHolder(holder: StarWarsListViewHolder, position: Int) {
        getItem(position).apply {
            holder.testTransform(this ?: People("", "", listOf()))
//            holder.itemInformation(
//                this.name, this.gender, this.starships, this.isHeart
//            )
        }
        
    }
    
}