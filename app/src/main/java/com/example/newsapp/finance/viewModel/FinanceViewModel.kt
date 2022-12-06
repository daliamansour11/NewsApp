package com.example.newsapp.finance.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.home.model.NewsResponse
import com.example.newsapp.repository.FinanceRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FinanceViewModel(val repo:FinanceRepository):ViewModel() {
    private val financeNews = MutableLiveData<NewsResponse>()
    val _financeNews : LiveData<NewsResponse>
        get() = financeNews
    lateinit var  job: Job

    fun getFinanceNews(api:String,lang:String,catgory:List<String>){
        job = viewModelScope.launch {
            val response = repo.getfinanceNews(api,lang,catgory)

            financeNews.postValue(response.body())
        }
    }

}
