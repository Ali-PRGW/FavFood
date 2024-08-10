package com.example.favfood.feature_fav_food.presentations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.FavoriteFood
import com.example.data.model.Food
import com.example.data.model.Person
import com.example.data.model.SampleData
import com.example.data.repository.FavFoodRepository
import com.example.data.repository.FoodRepository
import com.example.data.repository.PersonRepository
import com.example.data.repository.SampleDataRepository
import com.example.domain.use_case.DeleteFavoriteFoodUseCase
import com.example.domain.use_case.data_classes.FavFoodUseCases
import com.example.domain.use_case.data_classes.FoodUseCases
import com.example.domain.use_case.data_classes.PersonUseCases
import com.example.domain.use_case.data_classes.SampleDataUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavFoodViewModel @Inject constructor(

    private val personUseCases: com.example.domain.use_case.data_classes.PersonUseCases,
    private val foodUseCases: com.example.domain.use_case.data_classes.FoodUseCases,
    private val favFoodUseCases: com.example.domain.use_case.data_classes.FavFoodUseCases,
    private val removeFavoriteFoodUseCase: com.example.domain.use_case.DeleteFavoriteFoodUseCase,
    private val sampleDataUseCases: com.example.domain.use_case.data_classes.SampleDataUseCases,

    private val foodRepository: com.example.data.repository.FoodRepository,
    private val personRepository: com.example.data.repository.PersonRepository,
    private val favFoodRepository: com.example.data.repository.FavFoodRepository,
    private val sampleDataRepository: com.example.data.repository.SampleDataRepository
) : ViewModel() {

    private val _peopleState = MutableStateFlow<List<Person>>(emptyList())
    val peopleState: StateFlow<List<Person>>  = _peopleState.asStateFlow()

    private val _foodsState = MutableStateFlow<List<Food>>(emptyList())
    val foodsState: StateFlow<List<Food>> get() = _foodsState.asStateFlow()

    private val _favoriteFoodsState = MutableStateFlow<List<FavoriteFood>>(emptyList())
    val favoriteFoodsState: StateFlow<List<FavoriteFood>> get() = _favoriteFoodsState.asStateFlow()

    private val _sampleDataState = MutableStateFlow<List<SampleData>>(emptyList())
    val sampleDataState : StateFlow<List<SampleData>> get() = _sampleDataState

    init {
        loadPeople()
        loadFoods()
        loadSampleData()
    }


    fun loadPeople() {
        viewModelScope.launch {

            _peopleState.value = personRepository.getAllPeople()

        }
    }

    fun loadFoods() {
        viewModelScope.launch {

            _foodsState.value = foodRepository.getAllFoods()

        }
    }
    fun loadSampleData() {
        viewModelScope.launch {

            _sampleDataState.value = sampleDataRepository.getAllSampleData()

        }
    }

    fun loadFavoriteFoods(personId: Int) {
        viewModelScope.launch {
            _favoriteFoodsState.value = favFoodRepository.getFavsByPersonId(personId)
        }
    }

    fun addPerson(person: Person) {
        viewModelScope.launch {
            personUseCases.addPersonUseCase.invoke(person)
            loadPeople()
        }
    }

    fun addFood(food: Food) {

        viewModelScope.launch {
            foodUseCases.addFoodUseCase.invoke(food)
            loadFoods()
        }

    }

    fun addFavoriteFood(personId: Int, favoriteFood: FavoriteFood) {
        viewModelScope.launch {
            favFoodUseCases.addFavFoodUseCase.invoke(favoriteFood)
            loadFavoriteFoods(personId)
        }
    }

    fun removeFavoriteFood(personId: Int, favoriteFood: FavoriteFood) {
        viewModelScope.launch {
            removeFavoriteFoodUseCase.invoke(favoriteFood)
            loadFavoriteFoods(personId)
        }
    }

    fun insertSampleData(sampleData: SampleData){

        viewModelScope.launch {
            sampleDataUseCases.insertSampleDataUseCase.invoke(sampleData)
            loadSampleData()

        }

    }

}