package com.example.data.repository

import com.example.data.model.SampleData

interface SampleDataRepository {


    suspend fun insertSampleData(sampleData: SampleData) :Long


    suspend fun getAllSampleData() :List<SampleData>


}