package com.nahuel.predictionapp.data.network

import com.nahuel.predictionapp.data.RepositoryImpl
import com.nahuel.predictionapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newastro.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesPredictionApiService(retrofit: Retrofit):PredictionApiService{
        return retrofit.create(PredictionApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: PredictionApiService):Repository{
        return RepositoryImpl(apiService)
    }
}