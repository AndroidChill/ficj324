package com.example.starwars.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface StarWarsDao {
    @Insert(entity = StarWarsDataEntity::class)
    fun insertNewDataName(entity: StarWarsDataEntity): Long

    @Query("SELECT name_people FROM people")
    fun getData(): List<StarWarsDataEntity>

    @Query("DELETE FROM people WHERE name_people = :name")
    fun deleteDataByName(name: String): Int
}