package com.example.roommvvm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student (
    @PrimaryKey(autoGenerate = true) var id: Int? = null,

    @ColumnInfo var name: String = ""
)