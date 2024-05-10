package com.harkhark.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val TIME_OUT = 10L

    private const val BASE_URL = "https://love-calculator.p.rapidapi.com/"

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Singleton
    @LoveCalculatorRetrofit
    @Provides
    fun provideRapidRetrofit(
        @RapidInterceptorHttpClient okHttpClient: OkHttpClient,
        networkJson: Json,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build()

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor.Logger { message -> Timber.tag("okHttp").d(message) }
        return HttpLoggingInterceptor(logger)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RapidInterceptorHttpClient
    @RapidInterceptorHttpClient
    @Provides
    fun provideRapidOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor {
                it.proceed(
                    it.request().newBuilder()
                        .addHeader("X-RapidAPI-Key", "e035fe769fmshb310cf704937464p1bba68jsn529b393dbaf4")
                        .addHeader("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
                        .build()
                )
            }
            .build()
    }
}
