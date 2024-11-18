package com.mishbanya.effectivemobiletest2data.courses.module

import android.util.Log
import com.mishbanya.effectivemobiletest2data.courses.service.ICoursesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoursesModule {

    @Provides
    @Singleton
    fun provideCoursesService(
        retrofit: Retrofit
    ): ICoursesService {
        Log.d("Hilt", "Creating ICoursesService client instance")
        return retrofit.create(ICoursesService::class.java)
    }
}