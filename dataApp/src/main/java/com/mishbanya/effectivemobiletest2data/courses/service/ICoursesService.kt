package com.mishbanya.effectivemobiletest2data.courses.service

import com.mishbanya.effectivemobiletest2data.courses.model.CoursesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ICoursesService {
    @GET("courses")
    fun getCourse(@Query("page") page: Int): Single<Response<CoursesResponse>>
}
