package com.mishbanya.effectivemobiletest2data.courses.model

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("page")
    val page: Int,

    @SerializedName("has_next")
    val hasNext: Boolean,

    @SerializedName("has_previous")
    val hasPrevious: Boolean
)
