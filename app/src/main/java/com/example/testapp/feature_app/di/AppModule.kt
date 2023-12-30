package com.example.testapp.feature_app.di

import android.content.Context
import com.example.testapp.core.utils.Constants
import com.example.testapp.feature_app.data.local.AppDatabase
import com.example.testapp.feature_app.data.local.dao.CameraDao
import com.example.testapp.feature_app.data.local.dao.DoorDao
import com.example.testapp.feature_app.data.remote.HomeApi
import com.example.testapp.feature_app.data.repository.HomeRepositoryImpl
import com.example.testapp.feature_app.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)

    @Singleton
    @Provides
    fun provideHomeRepository(homeApi: HomeApi): HomeRepository = HomeRepositoryImpl(homeApi)


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getInstance(context)

    @Singleton
    @Provides
    fun provideDoorDao(database: AppDatabase): DoorDao = database.doorDao()

    @Singleton
    @Provides
    fun provideCameraDao(database: AppDatabase): CameraDao = database.cameraDao()


}

