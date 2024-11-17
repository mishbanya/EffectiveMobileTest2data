package com.mishbanya.effectivemobiletest2data.courses.repository

import com.mishbanya.effectivemobiletest2data.courses.model.CourseModel

interface ICoursesSaverRepository {
    fun saveCourses(courses: List<CourseModel>?): Boolean
}
