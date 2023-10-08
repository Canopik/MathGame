package com.example.mathgame.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "trivia_questions")
data class TriviaQuestion(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val category: String,
    val type: String,
    val difficulty: String,
    val question: String
)