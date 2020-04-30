package com.example.roommvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roommvvm.dao.StudentDao
import com.example.roommvvm.entity.Student

@Database(entities = arrayOf(Student::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "student-database")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}