package com.example.catsapi.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.catsapi.db.dao.CatDao
import com.example.catsapi.models.All
import com.example.catsapi.models.Cat

@Database(entities = [All::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCatDao(): CatDao

    companion object {

        const val DB_NAME = "cats.db"

        var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    instance = Room.databaseBuilder(context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                }
            }

            return instance
        }
    }
}