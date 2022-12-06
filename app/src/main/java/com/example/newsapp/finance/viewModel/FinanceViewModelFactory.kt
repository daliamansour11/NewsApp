package com.example.newsapp.finance.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.repository.FinanceRepository
import com.example.newsapp.sports.viewModel.SportsViewModel

class FinanceViewModelFactory(val repository: FinanceRepository):ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FinanceViewModel::class.java)) {
            FinanceViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
