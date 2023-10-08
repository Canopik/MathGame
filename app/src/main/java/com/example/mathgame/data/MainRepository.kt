package com.example.mathgame.data

import androidx.lifecycle.LiveData
import com.example.mathgame.data.data_source.QuestionsLocalDataSource
import com.example.mathgame.data.data_source.QuestionsRemoteDataSource
import com.example.mathgame.data.models.TriviaQuestion
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val remoteSource: QuestionsRemoteDataSource,
    private val localSource: QuestionsLocalDataSource
) {
    fun getQuestions(amount: Int = 10): LiveData<List<TriviaQuestion>> {
        remoteSource.getQuestionList(amount).observeForever {
            localSource.insertTriviaQuestion(it)
        }
        return localSource.getAllTriviaQuestions()
    }
}