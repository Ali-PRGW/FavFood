package com.example.domain.use_case.data_classes

import com.example.domain.use_case.AddPersonUseCase
import com.example.domain.use_case.GetAllFoodUseCase
import com.example.domain.use_case.GetAllPeopleUseCase
import javax.inject.Inject

data class PersonUseCases
@Inject constructor(

    val addPersonUseCase: AddPersonUseCase,
    val getAllPeopleUseCase: GetAllPeopleUseCase
)
