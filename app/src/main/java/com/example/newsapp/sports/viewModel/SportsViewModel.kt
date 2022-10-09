package com.example.newsapp.sports.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.home.model.NewsResponse
import com.example.newsapp.repository.SportsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SportsViewModel(val repo:SportsRepository) :ViewModel() {
    private val sportsNews = MutableLiveData<NewsResponse>()
    val _sportNews :LiveData<NewsResponse>
    get() = sportsNews
   lateinit var  job:Job
    fun getNSportNews(api:String,lang:String,catgory:List<String>){
        job = viewModelScope.launch {
            val response = repo.getSportNews(api,lang,catgory)
            sportsNews.postValue(response.body())
        }
    }

}