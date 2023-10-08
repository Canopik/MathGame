package com.example.mathgame.data.data_source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mathgame.data.models.TriviaQuestion
import com.example.mathgame.data.service.TriviaApiService
import com.example.mathgame.data.service.TriviaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestionsRemoteDataSource {
    private val TAG = "QuestionsDataSource"

    fun getQuestionList(amount: Int, category: Int = 19): LiveData<List<TriviaQuestion>> {
        val triviaResponse = MutableLiveData<List<TriviaQuestion>>()
        val service = TriviaApiClient.triviaApiService
        val call = service.getTriviaQuestions(amount = amount, category = category)
        call.enqueue(object : Callback<TriviaResponse> {
            override fun onResponse(call: Call<TriviaResponse>, response: Response<TriviaResponse>) {
                if (response.isSuccessful) {
                    triviaResponse.value = response.body()!!.results
                    Log.d(TAG, "response isSuccessful")
                } else {
                    Log.e(TAG, "response isSuccessful error")
                }
            }

            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                Log.e(TAG, "onFailure")
            }
        })
        return triviaResponse
    }
}


object TriviaApiClient {
    private const val BASE_URL = "https://opentdb.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val triviaApiService: TriviaApiService = retrofit.create(TriviaApiService::class.java)
}