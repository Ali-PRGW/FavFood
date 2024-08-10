package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.Upsert
import com.example.data.model.SampleData

@Dao
interface SampleDataDao {

    @Upsert
    fun insertSampleData(sampleData: SampleData) :Long

    @Query("SELECT * FROM SampleData ")
    fun getAllSampleData(): List<SampleData>


}