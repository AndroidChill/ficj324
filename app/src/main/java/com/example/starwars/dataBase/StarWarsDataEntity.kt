package com.example.starwars.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class StarWarsDataEntity(
    @PrimaryKey @ColumnInfo(name = "name_people") val name: String
)