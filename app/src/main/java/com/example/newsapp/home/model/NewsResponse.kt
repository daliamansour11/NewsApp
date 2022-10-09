package com.example.newsapp.home.model


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("nextPage")
    val nextPage: Int? = null,
    @SerializedName("results")
    val results: List<Result?>,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null
)