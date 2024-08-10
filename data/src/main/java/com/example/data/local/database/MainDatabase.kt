package com.example.data.local.database


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.local.dao.FavFoodDao
import com.example.data.local.dao.FoodDao
import com.example.data.local.dao.PersonDao
import com.example.data.local.dao.SampleDataDao
import com.example.data.model.FavoriteFood
import com.example.data.model.Food
import com.example.data.model.Person
import com.example.data.model.SampleData


@Database(
    entities = [Person::class, Food::class, FavoriteFood::class , SampleData::class],
    version = 2,
    exportSchema = false
)
abstract class MainDatabase : RoomDatabase() {


    abstract fun personDao(): PersonDao
    abstract fun foodDao(): FoodDao
    abstract fun favFoodDao(): FavFoodDao
    abstract fun sampleDataDao() : SampleDataDao

    companion object {

        const val DATABASE_NAME = "main_db"

    }


}


