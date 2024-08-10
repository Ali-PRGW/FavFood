package com.example.domain.use_case


import com.example.data.repository.FavFoodRepository
import com.example.data.model.FavoriteFood
import javax.inject.Inject

class AddFavFoodUseCase @Inject constructor(

    private val repository: FavFoodRepository

) {

    suspend fun invoke(favoriteFood: FavoriteFood){

        repository.insertFavFood( favoriteFood )

    }


}