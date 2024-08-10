package com.example.domain.use_case

import com.example.data.model.SampleData
import com.example.data.repository.SampleDataRepository
import javax.inject.Inject

class GetAllSampleDataUseCase @Inject constructor(

    private val sampleDataRepository: SampleDataRepository

) {

    suspend fun invoke() :List<SampleData>{

        return sampleDataRepository.getAllSampleData()

    }

}