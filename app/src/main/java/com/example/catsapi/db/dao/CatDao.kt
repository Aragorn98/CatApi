package com.example.catsapi.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.catsapi.models.All
import com.example.catsapi.repository.CatRepositoryInterface
import com.example.catsapi.models.Cat

@Dao
interface CatDao {
    @Query("SELECT * FROM cats")
    suspend fun getCats(): List<All>

    @Insert
    suspend fun insertCats(facts: List<All>)
}