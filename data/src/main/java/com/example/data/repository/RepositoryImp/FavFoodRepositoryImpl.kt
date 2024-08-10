package com.example.data.repository.RepositoryImp

import com.example.data.local.dao.FavFoodDao

import com.example.data.model.FavoriteFood
import com.example.data.repository.FavFoodRepository
import javax.inject.Inject

class FavFoodRepositoryImpl @Inject constructor(
    private val favFoodDao: com.example.data.local.dao.FavFoodDao
) : FavFoodRepository {

    override suspend fun insertFavFood(favoriteFood: FavoriteFood) :Long{

        return favFoodDao.insertFavFood(favoriteFood)

    }

    override suspend fun getFavsByPersonId(personId: Int): List<FavoriteFood> {

        return favFoodDao.getFavsByPersonId(personId)

    }

    override suspend fun deleteFavFood(favoriteFood: FavoriteFood) {

        favFoodDao.deleteFavoriteFood(favoriteFood)

    }
}