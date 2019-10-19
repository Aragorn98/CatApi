package com.example.catsapi

import android.content.Context
import com.example.catsapi.api.CatApi
import com.example.catsapi.api.CatService
import com.example.catsapi.db.AppDatabase
import com.example.catsapi.db.dao.CatDao
import com.example.lab3.databaseProject.repositories.CatApiRepository
import com.example.lab3.databaseProject.repositories.CatDaoRepository
import com.example.lab3.databaseProject.viewModels.CatViewModelFactory


object Injection {

    fun provideCatApiDataSource(): CatApi {
        return CatService.catAPI
    }

    fun provideCatDataSource(context: Context): CatDao {
        val database = AppDatabase.getDatabase(context)
        return database!!.getCatDao()
    }

    fun provideCatDaoRepository(context: Context): CatDaoRepository {
        val dao = provideCatDataSource(context)
        return CatDaoRepository(dao)
    }

    fun provideCatApiRepository(): CatApiRepository {
        val dao = provideCatApiDataSource()
        return CatApiRepository(dao)
    }

    fun provideCatViewModelFactory(context: Context, type: String): CatViewModelFactory {
        return when(type){
            "room" -> CatViewModelFactory(provideCatDaoRepository(context))
            else -> CatViewModelFactory(provideCatApiRepository())
        }
    }



}