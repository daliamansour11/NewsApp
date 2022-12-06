package com.example.newsapp.repository

import com.example.newsapp.network.NewsApiService

class FinanceRepository (val apiService: NewsApiService){

        suspend fun getfinanceNews(apikey :String,lang :String,category :List<String>)=apiService.getSportnews(apikey,lang,category)
    }
