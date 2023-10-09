package com.nahuel.predictionapp.data.network

import com.nahuel.predictionapp.BuildConfig.BASE_URL
import com.nahuel.predictionapp.data.RepositoryImpl
import com.nahuel.predictionapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient{
        return OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
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