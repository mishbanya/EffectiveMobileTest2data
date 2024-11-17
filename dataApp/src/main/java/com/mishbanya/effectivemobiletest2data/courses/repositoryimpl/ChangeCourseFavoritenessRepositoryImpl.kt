package com.mishbanya.effectivemobiletest2data.courses.repositoryimpl

import com.mishbanya.effectivemobiletest2data.courses.repository.IChangeCourseFavoritenessRepository
import com.mishbanya.effectivemobiletest2data.courses.repository.ICoursesGetterRepository
import com.mishbanya.effectivemobiletest2data.courses.repository.ICoursesSaverRepository
import javax.inject.Inject

class ChangeCourseFavoritenessRepositoryImpl@Inject constructor(
    private val coursesSaverRepository: ICoursesSaverRepository,
    private val coursesGetterRepository: ICoursesGetterRepository
): IChangeCourseFavoritenessRepository {
    override fun changeFavoriteness(id: Int) {
        val courses = coursesGetterRepository.getCourses()
        if (courses != null) {
            for(course in courses){
                if(course.id == id) {
                    course.isFavorite = !course.isFavorite
                    break
                }
            }
        }
        coursesSaverRepository.saveCourses(courses)
    }
}