package com.example.project_music.adapters.base_adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>: RecyclerView.Adapter<BaseViewHolder<T>>() {
    protected var mDataList: List<T> = ArrayList()
    protected var mCallBack: BaseAdapterCallBack<T>? = null

    fun attachCallBack(callBack: BaseAdapterCallBack<T>){
        this.mCallBack = callBack
    }

    fun detachCallBack(){
        this.mCallBack = null
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(items: List<T>){
        (mDataList as ArrayList).addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: T){
        (mDataList as ArrayList).add(item)
        notifyItemInserted(mDataList.size - 1)
    }

    fun addItemToTop(item: T){
        (mDataList as ArrayList).add(0, item)
        notifyItemInserted(0)
    }

    fun updateItems(items: List<T>){
        (mDataList as ArrayList).clear()
        setList(items)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear(){
        (mDataList as ArrayList).clear()
        notifyDataSetChanged()
    }

    fun getItems(): List<T>{
        return mDataList
    }

    override fun getItemCount(): Int {
        return mDataList.count()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val item: T = mDataList[position]
        holder.bind(item)
        holder.bindClickListener(item, mCallBack)
    }

}