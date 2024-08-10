package com.example.data.repository.RepositoryImp

import com.example.data.local.dao.PersonDao
import com.example.data.model.Person
import com.example.data.repository.PersonRepository
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(
    private val personDao: com.example.data.local.dao.PersonDao
) : PersonRepository {
    override suspend fun insertPerson(person: Person): Long {

        return personDao.insertPerson(person)

    }

    override suspend fun getAllPeople(): List<Person> {

        return personDao.getAllPeople()

    }
}