package com.example.newsapp.sports.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Constant
import com.example.newsapp.R
import com.example.newsapp.home.model.Result
import com.example.newsapp.home.view.onItemClickListener
import com.example.newsapp.network.Api
import com.example.newsapp.repository.SportsRepository
import com.example.newsapp.sports.viewModel.SportsViewModel
import com.example.newsapp.sports.viewModel.SportsViewModelFactory


class SportFragment : Fragment(),onItemClickListener {
  lateinit var   recyclerView:RecyclerView
  lateinit var sportviewModel: SportsViewModel
  lateinit var sportsAdapter:SportsAdapter
  val catgoryList = listOf<String>("sports")

    var sportData : ArrayList<Result> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sport, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.sport_recyclerview)
        sportsAdapter =  SportsAdapter(requireContext(),this)
        recyclerView.adapter = sportsAdapter
         val repo  = SportsRepository(Api.apiService)
        sportviewModel = ViewModelProvider(this,SportsViewModelFactory(repo)).get(SportsViewModel::class.java)
        sportviewModel.getNSportNews(Constant.API_KEY,Constant.LANG,catgoryList)
        sportviewModel._sportNews.observe(viewLifecycleOwner,{
            sportData = it.results as ArrayList<Result>
            sportsAdapter.setData(sportData)
            sportsAdapter.notifyDataSetChanged()
        })
    }

    override fun onItemClicked(news: Result) {
    }
}