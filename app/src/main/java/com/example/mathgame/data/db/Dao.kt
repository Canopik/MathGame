package com.example.mathgame.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mathgame.data.models.TriviaQuestion

@Dao
interface TriviaQuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTriviaQuestion(question: List<TriviaQuestion>)

    @Query("SELECT * FROM trivia_questions")
    fun getAllTriviaQuestions(): LiveData<List<TriviaQuestion>>

    @Query("DELETE FROM trivia_questions")
    fun deleteAllTriviaQuestions()
}