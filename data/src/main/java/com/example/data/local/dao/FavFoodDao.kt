package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.FavoriteFood

@Dao
interface FavFoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun insertFavFood( favoriteFood: FavoriteFood) :Long


    @Query("SELECT * FROM FavoriteFood WHERE personId  = :personId")
     fun getFavsByPersonId(personId : Int) :List<FavoriteFood>


    @Delete
    fun deleteFavoriteFood(favoriteFood: FavoriteFood)

}