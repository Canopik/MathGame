package com.example.mathgame.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mathgame.data.models.TriviaQuestion


@Database(entities = [TriviaQuestion::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun triviaQuestionDao(): TriviaQuestionDao
}