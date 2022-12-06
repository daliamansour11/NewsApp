package com.example.newsapp.home.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.home.model.NewsResponse
import com.example.newsapp.repository.HomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository):ViewModel() {

     lateinit var  job : Job
     private  val mnews_reponse = MutableLiveData<NewsResponse>()
     val _mnews_reponse : LiveData<NewsResponse>
     get() = mnews_reponse
     fun getHomeNews(apiKey: String,lang:String){
        job = CoroutineScope(Dispatchers.Main).launch {
            val reponse = repository.getLatestNews(apiKey,lang)
            if (reponse.isSuccessful){
             mnews_reponse.postValue(reponse.body())
                Log.i("TAG", "getHomViewModeleNews:${reponse.body()} ")
        }

        else{
                Log.i("TAG", "getHomViewModeleNewseeeeeeerrrrrrrrrrr:${reponse.message()} ")
        }
        }
    }
}