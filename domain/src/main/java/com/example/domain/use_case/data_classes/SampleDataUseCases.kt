package com.example.domain.use_case.data_classes

import com.example.domain.use_case.GetAllSampleDataUseCase
import com.example.domain.use_case.InsertSampleDataUseCase
import javax.inject.Inject

data class SampleDataUseCases
@Inject constructor(

    val insertSampleDataUseCase: InsertSampleDataUseCase,
    val getAllSampleDataUseCase: GetAllSampleDataUseCase

)
