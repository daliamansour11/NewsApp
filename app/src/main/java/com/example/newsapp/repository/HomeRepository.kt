package com.example.newsapp.repository

import android.util.Log
import com.example.newsapp.network.NewsApiService
import retrofit2.Response

class HomeRepository( private val newsapi: NewsApiService) {



    suspend fun getLatestNews(api:String,lang:String) = newsapi.getnews(api,lang)


}




