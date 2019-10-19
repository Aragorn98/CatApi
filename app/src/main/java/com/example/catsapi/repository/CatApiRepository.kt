package com.example.lab3.databaseProject.repositories

import com.example.catsapi.api.CatApi
import com.example.catsapi.models.All
import com.example.catsapi.models.Cat
import com.example.catsapi.repository.CatRepositoryInterface
import kotlinx.coroutines.*

class CatApiRepository(private val dataSource: CatApi) : CatRepositoryInterface{
    override suspend fun insertCats(facts: List<All>) {

    }

    override suspend fun getCats(): List<All> {
        return withContext(Dispatchers.IO) {
            dataSource.getCats().all
        }
    }
}