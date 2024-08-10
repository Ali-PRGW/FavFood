package com.example.domain.use_case.data_classes

import com.example.domain.use_case.AddFavFoodUseCase
import com.example.domain.use_case.DeleteFavoriteFoodUseCase
import com.example.domain.use_case.GetFavoriteFoodUseCase
import javax.inject.Inject

data class FavFoodUseCases
@Inject constructor(

    val addFavFoodUseCase: AddFavFoodUseCase,
    val getFavoriteFoodUseCase: GetFavoriteFoodUseCase,
    val deleteFavoriteFoodUseCase : DeleteFavoriteFoodUseCase
)
