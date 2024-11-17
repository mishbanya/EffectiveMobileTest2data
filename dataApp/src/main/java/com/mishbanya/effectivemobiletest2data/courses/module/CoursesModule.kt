package com.mishbanya.effectivemobiletest2data.courses.module

import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.mishbanya.effectivemobiletest2data.courses.repository.IChangeCourseFavoritenessRepository
import com.mishbanya.effectivemobiletest2data.courses.repository.ICoursesGetterRepository
import com.mishbanya.effectivemobiletest2data.courses.repositoryimpl.ChangeCourseFavoritenessRepositoryImpl
import com.mishbanya.effectivemobiletest2data.courses.repositoryimpl.CoursesGetterRepositoryImpl
import com.mishbanya.effectivemobiletest2data.courses.repositoryimpl.CoursesSaverRepositoryImpl
import com.mishbanya.effectivemobiletest2data.courses.repository.ICoursesSaverRepository
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
    fun provideCoursesSaverRepositoryImpl(
        sharedPreferences: SharedPreferences,
        gson: Gson
    ): ICoursesSaverRepository {
        Log.d("Hilt", "Creating CoursesSaverRepositoryImpl client instance")
        return CoursesSaverRepositoryImpl(sharedPreferences, gson)
    }
    @Provides
    @Singleton
    fun provideCoursesGetterRepositoryImpl(
        sharedPreferences: SharedPreferences,
        gson: Gson
    ): ICoursesGetterRepository {
        Log.d("Hilt", "Creating CoursesGetterRepositoryImpl client instance")
        return CoursesGetterRepositoryImpl(sharedPreferences, gson)
    }

    @Provides
    @Singleton
    fun provideChangeCourseFavoritenessRepositoryImpl(
        vacanciesSaverRepository: ICoursesSaverRepository,
        vacanciesGetterRepository: ICoursesGetterRepository
    ): IChangeCourseFavoritenessRepository {
        Log.d("Hilt", "Creating ChangeCourseFavoritenessRepositoryImpl client instance")
        return ChangeCourseFavoritenessRepositoryImpl(vacanciesSaverRepository, vacanciesGetterRepository)
    }

    @Provides
    @Singleton
    fun provideCoursesService(
        retrofit: Retrofit
    ): ICoursesService {
        Log.d("Hilt", "Creating ICoursesService client instance")
        return retrofit.create(ICoursesService::class.java)
    }
}