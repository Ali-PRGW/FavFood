package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class Food @JvmOverloads constructor(

    @PrimaryKey(autoGenerate = true)
    var id : Int ,
    var foodName : String

)
