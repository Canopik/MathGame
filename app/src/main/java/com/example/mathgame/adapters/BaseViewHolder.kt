package com.example.project_music.adapters.base_adapters


import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder


abstract class BaseViewHolder<T>(itemView: View) : ViewHolder(itemView) {
    abstract fun bind(model: T)
    fun bindClickListener(model: T, callBack: BaseAdapterCallBack<T>?){
        itemView.setOnClickListener{
            callBack?.onItemClick(model, itemView)
        }
        itemView.setOnLongClickListener {
            if (callBack == null){
                false
            } else {
                callBack.onLongClick(model, itemView)
                true
            }
        }
    }
}
