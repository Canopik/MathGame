package com.example.mathgame.di

import android.content.Context
import androidx.room.Room
import com.example.mathgame.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context: Context
    ) : AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database.db"
        ).build()
}