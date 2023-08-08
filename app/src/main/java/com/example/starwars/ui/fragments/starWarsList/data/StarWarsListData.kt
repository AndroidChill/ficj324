package com.example.starwars.ui.fragments.starWarsList.data

data class StarWarsListData(
    val name: String,
    val gender: String,
    val starships: List<String>,
    var isHeart: Boolean
)