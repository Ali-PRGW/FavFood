package com.example.domain.use_case

import com.example.data.model.FavoriteFood
import com.example.data.repository.FavFoodRepository
import javax.inject.Inject

class GetFavoriteFoodUseCase @Inject constructor(

    private val repository: FavFoodRepository

) {

    suspend fun invoke(personId: Int) : List<FavoriteFood> {

        return repository.getFavsByPersonId(personId)
    }

}