package com.mishbanya.effectivemobiletest2data

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.mishbanya.effectivemobiletest2data.courses.service.ICoursesService
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


//ACTIVITY ONLY FOR TESTING
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var service: ICoursesService

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val disposable = service.getCourse(2)
            .map { it.courses }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { courses ->
                    courses.forEach { println(it) }
                },
                { error ->
                    Log.e("MainActivity", "Error fetching courses: ${error.message}")
                }
            )

        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}