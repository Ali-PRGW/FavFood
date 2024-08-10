package com.example.domain.use_case

import com.example.data.model.Food
import com.example.data.repository.FoodRepository
import javax.inject.Inject

class GetAllFoodUseCase @Inject constructor(
    private val repository: FoodRepository
) {


    suspend fun invoke() : List<Food>{

        return repository.getAllFoods()

    }




}