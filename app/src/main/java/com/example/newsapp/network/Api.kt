package com.example.newsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    private  val BASEURL  ="https://newsdata.io/api/1/"

    val retrofit =  Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
  val apiService = retrofit.create(NewsApiService::class.java)


}