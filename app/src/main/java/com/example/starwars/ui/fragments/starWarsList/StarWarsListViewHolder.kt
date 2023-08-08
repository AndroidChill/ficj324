package com.example.starwars.ui.fragments.starWarsList

import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.databinding.ItemInformationBinding

class StarWarsListViewHolder(
    private val binding: ItemInformationBinding,
    private val onClickFavourite: (String, Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var isSelect = false

    fun itemInformation(
        name: String,
        gender: String,
        starships: List<String>,
        isHeart: Boolean
    ) {
        with(binding) {

            tvName.text = "Cocktail name: $name"
            tvGender.text = "Cocktail id: $gender"
            tvStarships.text = "Cocktail category: $starships"
            isSelect = !isHeart
            select()

            ivHeart.setOnClickListener {
                onClickFavourite(name, isSelect)
                select()
            }
        }

    }

    private fun select() {
        if (isSelect) {
            binding.ivHeart.setImageResource(R.drawable.heart_empty)
        } else {
            binding.ivHeart.setImageResource(R.drawable.heart_full)
        }
        isSelect = !isSelect
    }
}