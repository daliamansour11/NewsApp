package com.example.newsapp.repository

import com.example.newsapp.network.NewsApiService

class SportsRepository(val apiService: NewsApiService){

    suspend fun getSportNews(apikey :String,lang :String,category :List<String>)=apiService.getSportnews(apikey,lang,category)
}