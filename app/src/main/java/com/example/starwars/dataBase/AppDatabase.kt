package com.example.starwars.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        StarWarsDataEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getStarWarsDao(): StarWarsDao

}