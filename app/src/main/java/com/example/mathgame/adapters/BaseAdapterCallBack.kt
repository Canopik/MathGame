package com.example.project_music.adapters.base_adapters

import android.view.View

interface BaseAdapterCallBack<T> {
    fun onItemClick(model: T, view: View)
    fun onLongClick(model: T, view: View)
}
