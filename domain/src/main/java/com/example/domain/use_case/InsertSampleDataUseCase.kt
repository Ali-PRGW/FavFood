package com.example.domain.use_case

import com.example.data.model.SampleData
import com.example.data.repository.SampleDataRepository
import javax.inject.Inject

class InsertSampleDataUseCase @Inject constructor(

    private val sampleDataRepository: SampleDataRepository

) {

    suspend fun invoke(sampleData: SampleData):Long{

        return sampleDataRepository.insertSampleData(sampleData)

    }


}