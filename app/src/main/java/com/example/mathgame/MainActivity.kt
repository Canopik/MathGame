package com.example.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mathgame.adapters.QuestionAdapter
import com.example.mathgame.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val mMenuViewModel: MainViewModel by viewModels()
    private lateinit var mRecycleView: RecyclerView
    private lateinit var mAdapter: QuestionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecycleView = findViewById((R.id.recyclerview))
        mAdapter = QuestionAdapter()
        setupAdapter()
        mMenuViewModel.getQuestionsList().observe(this, Observer {
            mAdapter.setList(it)
        })
    }

    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        mRecycleView.layoutManager = layoutManager
        mRecycleView.adapter = mAdapter
    }
}