package com.example.data.repository

import com.example.data.model.Food

interface FoodRepository {


    suspend fun insertFood (food: Food) :Long

    suspend fun getAllFoods() :List<Food>

    suspend fun getFoodById (foodId:Int): Food
}