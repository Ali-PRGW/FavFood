package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.Food


@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertFood(food: Food) :Long

    @Query("SELECT * FROM food")
    fun getAllFoods(): List<Food>

    @Query("SELECT * FROM food WHERE id = :foodId ")
    fun getFoodById(foodId :Int) : Food
}