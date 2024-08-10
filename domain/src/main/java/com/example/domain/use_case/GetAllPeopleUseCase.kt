package com.example.domain.use_case

import com.example.data.model.Person
import com.example.data.repository.PersonRepository
import javax.inject.Inject

class GetAllPeopleUseCase @Inject constructor(
    private val personRepository: PersonRepository
) {

    suspend fun invoke() :List<Person>{

        return personRepository.getAllPeople()

    }

}