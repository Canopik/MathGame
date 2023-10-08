package com.example.mathgame.data.data_source

import androidx.lifecycle.LiveData
import com.example.mathgame.data.db.AppDatabase
import com.example.mathgame.data.models.TriviaQuestion
import javax.inject.Inject

class QuestionsLocalDataSource @Inject constructor(
    private val dataBase: AppDatabase
) {

    private val triviaQuestionDao = dataBase.triviaQuestionDao()

    fun insertTriviaQuestion(triviaQuestion: List<TriviaQuestion>) {
        dataBase.queryExecutor.execute {
            triviaQuestionDao.deleteAllTriviaQuestions()
            triviaQuestionDao.insertTriviaQuestion(triviaQuestion)
        }
    }

    fun getAllTriviaQuestions(): LiveData<List<TriviaQuestion>> {
        return triviaQuestionDao.getAllTriviaQuestions()
    }
}

