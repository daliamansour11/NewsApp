package com.example.newsapp.network

import com.example.newsapp.home.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("news?")
    suspend fun getnews(
        @Query("apikey") apiKey :String,
        @Query("language") lang :String)
        :Response<NewsResponse>
//        @Query("country") country :List<String>,
//        @Query("category") category :List<String>,

    @GET("news?")
    suspend fun getSportnews(
        @Query("apikey") apiKey :String,
        @Query("language") lang :String,
        @Query("category") category :List<String>)

        :Response<NewsResponse>
//        @Query("country") country :List<String>,
//        @Query("category") category :List<String>,


}