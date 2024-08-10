package com.example.favfood.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMainDatabase(app: Application): com.example.data.local.database.MainDatabase {

        return Room.databaseBuilder(
            app,
            com.example.data.local.database.MainDatabase::class.java,
            com.example.data.local.database.MainDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    }
    /////////////////////////////////////////////////////////////////////////

    @Provides
    fun providePersonDao(db: com.example.data.local.database.MainDatabase): com.example.data.local.dao.PersonDao = db.personDao()

    @Provides
    @Singleton
    fun providePersonRepository(personDao: com.example.data.local.dao.PersonDao): com.example.data.repository.PersonRepository {

        return com.example.data.repository.RepositoryImp.PersonRepositoryImpl(personDao)

    }


    @Provides
    @Singleton
    fun providePersonUseCases(personRepository: com.example.data.repository.PersonRepository): com.example.domain.use_case.data_classes.PersonUseCases {

        return com.example.domain.use_case.data_classes.PersonUseCases(

            addPersonUseCase = com.example.domain.use_case.AddPersonUseCase(personRepository),
            getAllPeopleUseCase = com.example.domain.use_case.GetAllPeopleUseCase(personRepository)

        )

    }

/////////////////////////////////////////////////////////////////////////////////


    @Provides
    fun provideFoodDao(db: com.example.data.local.database.MainDatabase): com.example.data.local.dao.FoodDao = db.foodDao()

    @Provides
    @Singleton
    fun provideFoodRepository(foodDao: com.example.data.local.dao.FoodDao): com.example.data.repository.FoodRepository {

        return com.example.data.repository.RepositoryImp.FoodRepositoryImpl(foodDao)

    }


    @Provides
    @Singleton
    fun provideFoodUseCases(foodRepository: com.example.data.repository.FoodRepository): com.example.domain.use_case.data_classes.FoodUseCases {

        return com.example.domain.use_case.data_classes.FoodUseCases(

            addFoodUseCase = com.example.domain.use_case.AddFoodUseCase(foodRepository),
            getAllFoodUseCase = com.example.domain.use_case.GetAllFoodUseCase(foodRepository)

        )


    }

/////////////////////////////////////////////////////////////////////////////////


    @Provides
    fun provideFavoriteFoodDao(db: com.example.data.local.database.MainDatabase): com.example.data.local.dao.FavFoodDao {

        return db.favFoodDao()
    }

    @Provides
    @Singleton
    fun provideFavFoodRepository(favFoodDao: com.example.data.local.dao.FavFoodDao): com.example.data.repository.FavFoodRepository {

        return com.example.data.repository.RepositoryImp.FavFoodRepositoryImpl(favFoodDao)
    }


    @Provides
    @Singleton
    fun provideFavFoodUseCases(favFoodRepository: com.example.data.repository.FavFoodRepository): com.example.domain.use_case.data_classes.FavFoodUseCases {

        return com.example.domain.use_case.data_classes.FavFoodUseCases(

            addFavFoodUseCase = com.example.domain.use_case.AddFavFoodUseCase(favFoodRepository),
            getFavoriteFoodUseCase = com.example.domain.use_case.GetFavoriteFoodUseCase(
                favFoodRepository
            ),
            deleteFavoriteFoodUseCase = com.example.domain.use_case.DeleteFavoriteFoodUseCase(
                favFoodRepository
            )

        )


    }
//////////////////////////////////////////////////////////////////////////////////////////////////////

    @Provides
    fun provideSampleDataDao(db: com.example.data.local.database.MainDatabase): com.example.data.local.dao.SampleDataDao {

        return db.sampleDataDao()
    }

    @Provides
    @Singleton
    fun provideSampleDataRepository(sampleDataDao: com.example.data.local.dao.SampleDataDao): com.example.data.repository.SampleDataRepository {

        return com.example.data.repository.RepositoryImp.SampleDataRepositoryImp(sampleDataDao)
    }

    @Provides
    @Singleton
    fun provideSampleDataUseCases(sampleDataRepository: com.example.data.repository.SampleDataRepository): com.example.domain.use_case.data_classes.SampleDataUseCases {

        return com.example.domain.use_case.data_classes.SampleDataUseCases(

            insertSampleDataUseCase = com.example.domain.use_case.InsertSampleDataUseCase(
                sampleDataRepository
            ),
            getAllSampleDataUseCase = com.example.domain.use_case.GetAllSampleDataUseCase(
                sampleDataRepository
            )

        )


    }

}