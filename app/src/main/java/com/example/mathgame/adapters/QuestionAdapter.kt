package com.example.mathgame.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mathgame.R
import com.example.mathgame.data.models.TriviaQuestion
import com.example.project_music.adapters.base_adapters.BaseAdapter
import com.example.project_music.adapters.base_adapters.BaseViewHolder

class QuestionAdapter: BaseAdapter<TriviaQuestion>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TriviaQuestion> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_questions, parent, false)
        return QuestionViewHolder(view)
    }

    class QuestionViewHolder(itemView: View): BaseViewHolder<TriviaQuestion>(itemView){
        private val questionTextView: TextView = itemView.findViewById(R.id.tv_question)

        override fun bind(model: TriviaQuestion) {
            questionTextView.text = model.question
        }

    }
}