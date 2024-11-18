package com.mishbanya.effectivemobiletest2data.courses.model

import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("meta")
    val meta: Meta,

    @SerializedName("courses")
    val courses: List<CourseModel>,

    @SerializedName("enrollments")
    val enrollments: List<Any>
)
