package com.example.favfood


import android.graphics.Paint.Style
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.favfood.feature_fav_food.presentations.FavFoodViewModel
import com.example.data.model.FavoriteFood
import com.example.data.model.Food
import com.example.data.model.Person
import com.example.data.model.SampleData
import com.example.favfood.ui.theme.FavFoodTheme
import com.example.favfood.ui.theme.light_gray
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: FavFoodViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            FavFoodTheme {
                Surface(modifier = Modifier.fillMaxWidth(), color = Color.White) {

                    Column {

                        val navController = rememberNavController()
                        MainScreen(navController)

                    }
                }
            }
        }
    }


    @Composable
    fun MainScreen(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "persons") {
            composable("persons") { PersonScreen(navController) }
            composable("showPersons") { PersonShowScreen() }
            composable("favorites") { MyApp(viewModel = viewModel) }
            composable("showData"){ShowData()}
        }
    }


    @Composable
    fun PersonScreen(navController: NavHostController) {
        val viewModel: FavFoodViewModel by viewModels()
        var personName by remember { mutableStateOf("") }
        var foodName by remember { mutableStateOf("") }

        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = personName,
                onValueChange = { personName = it },
                label = { Text("Person Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                val newPerson =
                    Person(id = generateUniqueId(), name = personName)


                viewModel.addPerson(newPerson)
                personName = ""
            }) {
                Text("Add Person")
            }

            Spacer(modifier = Modifier.height(16.dp))


            Button(onClick = {

                navController.navigate("showPersons")

            })
            {
                Text("Go to Persons")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column {

                TextField(
                    value = foodName,
                    onValueChange = { foodName = it },
                    label = { Text("Food Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))


                Button(onClick = {
                    val newFood = Food(id = generateUniqueId(), foodName)
                    viewModel.addFood(newFood)
                    foodName = ""
                }) {
                    Text("Add Food")
                }


                Spacer(modifier = Modifier.height(16.dp))


                Button(onClick = {
                    navController.navigate("favorites")
                }) {
                    Text("Go to Favorites")
                }


             ////////////////////////////////////////////////////////////


                Button(onClick = {

                    navController.navigate("showData")


                }) {

                    Text(text = "Example Activity")

                }


            }
        }


    }

    @Composable
    fun ShowData(){

        var dataIn by remember { mutableStateOf("") }

        Column(modifier = Modifier.padding(16.dp)) {

            TextField(
                value = dataIn,
                onValueChange = { dataIn = it },
                label = { Text("Insert your data ") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                val newSampleData =
                    SampleData(id = generateUniqueId(), data = dataIn)

                viewModel.insertSampleData(newSampleData)
                dataIn = ""

            }) {
                Text("Add data")
            }


            val allData by viewModel.sampleDataState.collectAsState()

            Surface(modifier = Modifier.fillMaxWidth()) {
                LazyColumn {
                    items(allData) {
                        Text(
                            text = it.data,
                            modifier = Modifier.padding(16.dp),

                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )

                        )
                    }
                }

            }


        }

    }


    @Composable
    fun PersonShowScreen() {

        val persons by viewModel.peopleState.collectAsState()

        Surface(modifier = Modifier.fillMaxWidth()) {
            LazyColumn {
                items(persons) { person ->
                    Text(
                        text = person.name,
                        modifier = Modifier.padding(16.dp),

                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )

                    )
                }
            }

        }

    }


    private fun generateUniqueId(): Int {
        return (1..1000).random()
    }


    @Composable
    fun MyApp(viewModel: FavFoodViewModel) {
        val people by viewModel.peopleState.collectAsState()
        val foods by viewModel.foodsState.collectAsState()
        val favoriteFoods by viewModel.favoriteFoodsState.collectAsState()
        val selectedPersonId = remember { mutableStateOf<Int?>(null) }

        Column {
            PeopleList(people) { personId ->
                selectedPersonId.value = personId
            }

            selectedPersonId.value?.let { personId ->
                LaunchedEffect(personId) {
                    viewModel.loadFavoriteFoods(personId)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Favorite Foods :",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Medium,
                        fontSize = 24.sp
                    )
                )


                FoodsList(foods, favoriteFoods) { food, isSelected ->
                    val favoriteFood = FavoriteFood(personId, food.id)
                    if (isSelected) {
                        viewModel.addFavoriteFood(personId, favoriteFood)
                    } else {
                        viewModel.removeFavoriteFood(personId, favoriteFood)
                    }
                }
            }
        }
    }
}

@Composable
fun PeopleList(people: List<Person>, onPersonSelected: (Int) -> Unit) {
    LazyColumn {
        items(people) { person ->
            Text(
                text = person.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { onPersonSelected(person.id) },
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
        }
    }
}

@Composable
fun FoodsList(
    foods: List<Food>,
    favoriteFoods: List<FavoriteFood>,
    onFavoriteToggled: (Food, Boolean) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        foods.forEach { food ->
            var isSelected = favoriteFoods.any { it.foodId == food.id }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isSelected,
                    onCheckedChange = { checked ->
                        isSelected = checked
                        onFavoriteToggled(food, isSelected)
                    }
                )
                Text(text = food.foodName)
            }
        }

    }

}






