package com.example.data.repository.RepositoryImp

import com.example.data.local.dao.SampleDataDao
import com.example.data.model.SampleData
import com.example.data.repository.SampleDataRepository
import javax.inject.Inject

class SampleDataRepositoryImp @Inject constructor(

    private val sampleDataDao: com.example.data.local.dao.SampleDataDao

) : SampleDataRepository {
    override suspend fun insertSampleData(sampleData: SampleData) :Long {

        return sampleDataDao.insertSampleData(sampleData = sampleData)

    }

    override suspend fun getAllSampleData(): List<SampleData> {


        return sampleDataDao.getAllSampleData()

    }


}