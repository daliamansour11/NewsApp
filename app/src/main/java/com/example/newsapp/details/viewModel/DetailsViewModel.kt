package com.example.newsapp.details.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.home.model.NewsResponse
import com.example.newsapp.repository.DetailsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailsViewModel(val repo:DetailsRepository):ViewModel() {

    private val newsDetails= MutableLiveData<NewsResponse>()

    val _newsDetails:LiveData<NewsResponse>
        get() =  newsDetails
    lateinit var job:Job

    fun showNewsDetails(){
        job = viewModelScope.launch {
            var reponse = repo.showNewsDetails()
          //  newsDetails.postValue(reponse)

        }
    }

}