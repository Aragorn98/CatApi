package com.example.lab3.databaseProject.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catsapi.models.All
import com.example.catsapi.models.Cat
import com.example.catsapi.repository.CatRepositoryInterface
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class CatViewModel(private val dataSource: CatRepositoryInterface) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private val mutableCats = MutableLiveData<List<All>>()

    val cats: LiveData<List<All>>
        get() = mutableCats

    fun getCats() {
        launch {
            mutableCats.postValue(dataSource.getCats())
        }
    }

    fun insertCats(facts: List<All>) {
        launch {
            dataSource.insertCats(facts)
        }
    }
}