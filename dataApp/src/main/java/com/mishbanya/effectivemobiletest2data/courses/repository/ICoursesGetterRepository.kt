package com.mishbanya.effectivemobiletest2data.courses.repository

import com.mishbanya.effectivemobiletest2data.courses.model.CourseModel

interface ICoursesGetterRepository {
    fun getCourses(): List<CourseModel>?
}
