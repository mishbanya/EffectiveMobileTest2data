package com.mishbanya.effectivemobiletest2data.common.module

import android.util.Log
import com.google.gson.Gson
import com.mishbanya.effectivemobiletest2data.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofitClient(
        gson: Gson
    ): Retrofit {
        Log.d("Hilt", "Creating Retrofit client instance")
        return Retrofit.Builder()
            .baseUrl("https://stepik.org:443/api/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}