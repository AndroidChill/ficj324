package com.example.starwars.ui.fragments.starWarsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.databinding.ItemInformationBinding

class StarWarsListAdapter(
    private val onClickFavourite: (String, Boolean) -> Unit
) : RecyclerView.Adapter<StarWarsListViewHolder>() {

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

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: StarWarsListViewHolder, position: Int) {
        data[position].apply {
            holder.itemInformation(
                this.name,
                this.gender,
                this.starships,
                this.isHeart
            )
        }

    }

}