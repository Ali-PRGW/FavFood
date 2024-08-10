package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class Person @JvmOverloads constructor(

    @PrimaryKey(autoGenerate = true)
    var id :Int ,
    var name :String

)