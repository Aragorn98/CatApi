package com.example.catsapi.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Cat(
    val id: Int? = null,
    val all: List<All>
)
@Entity(tableName = "cats")
data class All(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "fact_id") val _id: String,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "upvotes") val upvotes: Int
)

data class User(
    val _id: String,
    val name: Name
)

data class Name(
    val first: String,
    val last: String
)