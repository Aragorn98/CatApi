package com.example.catsapi.repository

import com.example.catsapi.models.All

interface CatRepositoryInterface {
    suspend fun getCats(): List<All>
    suspend fun insertCats(facts: List<All>)
}