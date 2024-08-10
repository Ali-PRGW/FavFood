package com.example.data.repository

import com.example.data.model.Person

interface PersonRepository {

    suspend fun insertPerson(person: Person) : Long


    suspend fun getAllPeople() :List<Person>

}