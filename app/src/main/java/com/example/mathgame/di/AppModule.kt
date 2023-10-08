package com.example.mathgame.di

import android.content.Context
import androidx.room.Room
import com.example.mathgame.data.MainRepository
import com.example.mathgame.data.data_source.QuestionsLocalDataSource
import com.example.mathgame.data.data_source.QuestionsRemoteDataSource
import com.example.mathgame.data.db.AppDatabase
import com.example.mathgame.view_model.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMainViewModel(
        mainRepository: MainRepository
    ): MainViewModel = MainViewModel(mainRepository)

    @Provides
    @Singleton
    fun provideMainRepository(
        remoteDataSource: QuestionsRemoteDataSource,
        localDataSource: QuestionsLocalDataSource
    ): MainRepository = MainRepository(remoteDataSource, localDataSource)

    @Provides
    @Singleton
    fun provideRemoteDataSource(): QuestionsRemoteDataSource = QuestionsRemoteDataSource()

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: AppDatabase
    ): QuestionsLocalDataSource = QuestionsLocalDataSource(database)
}