package com.example.domain.use_case

import com.example.data.model.FavoriteFood
import com.example.data.repository.FavFoodRepository
import javax.inject.Inject

class DeleteFavoriteFoodUseCase @Inject constructor(
    private val repository: FavFoodRepository
) {

    suspend fun invoke(favoriteFood: FavoriteFood)  {
        repository.deleteFavFood(favoriteFood)
    }

}