package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SampleData")
data class SampleData @JvmOverloads constructor(

    @PrimaryKey(autoGenerate = true)
    val id :Int ,
    val data : String

)