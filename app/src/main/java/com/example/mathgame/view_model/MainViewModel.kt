package com.example.mathgame.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mathgame.data.MainRepository
import com.example.mathgame.data.models.TriviaQuestion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {
    fun getQuestionsList(): LiveData<List<TriviaQuestion>> = mainRepository.getQuestions()
}