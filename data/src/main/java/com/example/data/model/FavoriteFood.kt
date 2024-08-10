package com.example.data.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "FavoriteFood",
    primaryKeys = ["personId", "foodId"],
    foreignKeys = [
        ForeignKey(entity = Person::class, parentColumns = ["id"], childColumns = ["personId"]),
        ForeignKey(entity = Food::class, parentColumns = ["id"], childColumns = ["foodId"])
    ] )
data class FavoriteFood @JvmOverloads constructor(

    val personId :Int,

    val foodId:Int

)
