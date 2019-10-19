package com.example.catsapi

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catsapi.adapters.CatsAdapter
import com.example.coroutineproject.di.type
import com.example.lab3.databaseProject.viewModels.CatViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    fun Context.isConnectedToNetwork(): Boolean {
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting() ?: false
    }

//    private val catViewModel by lazy {
//        ViewModelProviders.of(this, Injection.provideCatViewModelFactory(this, type))
//            .get(CatViewModel::class.java)
//    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {
        cats_list.layoutManager = LinearLayoutManager(this)

        if(isConnectedToNetwork()) {
            type = "api"
        }
        else {
            type = "room"
        }

        val catViewModel: CatViewModel by viewModel()


        catViewModel.cats.observe(this@MainActivity, Observer { cats ->
            val adapter = CatsAdapter(cats!!)
            cats_list.adapter = adapter
            if(type == "api") {
                type = "room"
                val catViewModel: CatViewModel by viewModel()
                catViewModel.insertCats(cats)
            }
        })
        catViewModel.getCats()

    }
}
