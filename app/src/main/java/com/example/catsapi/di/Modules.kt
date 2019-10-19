package com.example.coroutineproject.di

import androidx.room.Room
import com.example.catsapi.api.CatApi
import com.example.catsapi.api.CatService
import com.example.catsapi.db.AppDatabase
import com.example.catsapi.db.dao.CatDao
import com.example.lab3.databaseProject.repositories.CatApiRepository
import com.example.lab3.databaseProject.repositories.CatDaoRepository
import com.example.lab3.databaseProject.viewModels.CatViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    single { Room.databaseBuilder(androidContext(),
        AppDatabase::class.java, AppDatabase.DB_NAME).build() }

    single { get<AppDatabase>().getCatDao() }
}

val apiModule = module {
    single { CatService.catAPI }
}

val repoModule = module {
    single { CatDaoRepository(get() as CatDao) }
    single { CatApiRepository(get() as CatApi) }
}
var type = "room"
val viewModelModule = module {
    if (type == "room") viewModel { CatViewModel(get() as CatDaoRepository) }
    else viewModel { CatViewModel(get() as CatApiRepository) }
}