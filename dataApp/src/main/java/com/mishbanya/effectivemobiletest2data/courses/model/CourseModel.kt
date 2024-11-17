package com.mishbanya.effectivemobiletest2data.courses.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class CourseModel(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("became_published_at")
    val becamePublishedAt: Date?,

    @SerializedName("certificate_regular_threshold")
    val rating: Float?,

    @SerializedName("cover")
    val cover: String?,

    @SerializedName("price")
    val price: Double?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("is_favorite")
    var isFavorite: Boolean = false
)
