package com.example.lab3.databaseProject.repositories

import android.util.Log
import com.example.catsapi.db.dao.CatDao
import com.example.catsapi.models.All
import com.example.catsapi.models.Cat
import com.example.catsapi.repository.CatRepositoryInterface
import kotlinx.coroutines.*

class CatDaoRepository(private val dataSource: CatDao) : CatRepositoryInterface{
    override suspend fun insertCats(facts: List<All>) {
        Log.d("argyn", "adding")
        withContext(Dispatchers.IO) {
            dataSource.insertCats(facts)
        }
    }

    override suspend fun getCats(): List<All> {
        return withContext(Dispatchers.IO) {
            dataSource.getCats()
        }
    }


}