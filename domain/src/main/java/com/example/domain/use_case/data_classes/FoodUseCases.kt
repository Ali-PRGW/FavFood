package com.example.domain.use_case.data_classes

import com.example.domain.use_case.AddFoodUseCase
import com.example.domain.use_case.GetAllFoodUseCase
import javax.inject.Inject

data class FoodUseCases
@Inject constructor(

    val addFoodUseCase: AddFoodUseCase,
    val getAllFoodUseCase: GetAllFoodUseCase

)
