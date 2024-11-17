package com.mishbanya.effectivemobiletest2data.courses.service

import com.mishbanya.effectivemobiletest2data.courses.model.CourseModel
import com.mishbanya.effectivemobiletest2data.courses.model.CoursesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ICoursesService {
    @GET("/api/courses")
    fun getCourse(@Query("page") page: Int): Single<CoursesResponse>
}
