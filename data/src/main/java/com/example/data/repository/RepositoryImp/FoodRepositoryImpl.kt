package com.example.data.repository.RepositoryImp

import com.example.data.local.dao.FoodDao
import com.example.data.model.Food
import com.example.data.repository.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodDao: com.example.data.local.dao.FoodDao
) : FoodRepository {
    override suspend fun insertFood(food: Food) :Long{

        return foodDao.insertFood(food)

    }

    override suspend fun getAllFoods(): List<Food> {

        return foodDao.getAllFoods()

    }

    override suspend fun getFoodById(foodId:Int): Food {

        return foodDao.getFoodById(foodId)
    }

}