package com.example.newsapp.sports.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.home.viewModel.HomeViewModel
import com.example.newsapp.repository.HomeRepository
import com.example.newsapp.repository.SportsRepository

class SportsViewModelFactory (val repository: SportsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SportsViewModel::class.java)) {
            SportsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}