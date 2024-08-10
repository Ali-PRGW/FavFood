package com.example.data.repository

import com.example.data.model.FavoriteFood
import com.example.data.model.Food


interface FavFoodRepository {


    suspend fun insertFavFood( favoriteFood: FavoriteFood):Long


    suspend fun getFavsByPersonId(personId : Int) :List<FavoriteFood>


    suspend fun deleteFavFood(favoriteFood: FavoriteFood)

}