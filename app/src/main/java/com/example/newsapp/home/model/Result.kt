package com.example.newsapp.home.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("category")
    val category: List<String?>? = null,
    @SerializedName("content")
    val content: String? = null,
    @SerializedName("country")
    val country: List<String?>? = null,
    @SerializedName("creator")
    val creator: List<String?>? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("keywords")
    val keywords: List<String?>? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("link")
    val link: String? = null,
    @SerializedName("pubDate")
    val pubDate: String? = null,
    @SerializedName("source_id")
    val sourceId: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("video_url")
    val videoUrl: Any? = null
)