package com.example.domain.use_case

import com.example.data.repository.FoodRepository
import com.example.data.model.Food
import javax.inject.Inject

class AddFoodUseCase @Inject constructor(
    private val foodRepository: FoodRepository
) {

    suspend fun invoke(food: Food) {

        if (food.foodName.isNotBlank()) {
            foodRepository.insertFood(food)
        }
    }


}