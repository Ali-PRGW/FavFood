package com.example.domain.use_case

import com.example.data.model.Person
import com.example.data.repository.PersonRepository
import javax.inject.Inject

class AddPersonUseCase @Inject constructor(
    private val personRepository: PersonRepository
) {

    suspend fun invoke(person: Person)  {
        if (person.name.isNotBlank()) {
            personRepository.insertPerson(person)
        }
    }
}