package com.example.mathgame.data.service

import com.example.mathgame.data.models.TriviaQuestion
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface TriviaApiService  {
    @GET("api.php?")
    fun getTriviaQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: Int
    ): Call<TriviaResponse>
}


data class TriviaResponse(
    val results: List<TriviaQuestion>
)
