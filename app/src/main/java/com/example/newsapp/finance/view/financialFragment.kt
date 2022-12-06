package com.example.newsapp.finance.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Constant
import com.example.newsapp.R
import com.example.newsapp.details.view.Details_Fragment
import com.example.newsapp.finance.viewModel.FinanceViewModel
import com.example.newsapp.finance.viewModel.FinanceViewModelFactory
import com.example.newsapp.home.model.Result
import com.example.newsapp.home.view.onItemClickListener
import com.example.newsapp.network.Api
import com.example.newsapp.repository.FinanceRepository
import com.example.newsapp.repository.SportsRepository
import com.example.newsapp.sports.view.SportsAdapter
import com.example.newsapp.sports.viewModel.SportsViewModel
import com.example.newsapp.sports.viewModel.SportsViewModelFactory
import java.text.FieldPosition

class financialFragment : Fragment(),onItemClickListener {

    lateinit var   recyclerView: RecyclerView
    lateinit var financeviewModel: FinanceViewModel
    lateinit var financeAdapter: FinanceAdapter
    val catgoryList = listOf<String>("business")

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
        return inflater.inflate(R.layout.fragment_financial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.finance_recyclerview)
        financeAdapter =  FinanceAdapter(requireContext(),this)
        recyclerView.adapter = financeAdapter
        val repo  = FinanceRepository(Api.apiService)
        financeviewModel = ViewModelProvider(this, FinanceViewModelFactory(repo)).get(FinanceViewModel::class.java)
        financeviewModel.getFinanceNews(Constant.API_KEY, Constant.LANG,catgoryList)
        financeviewModel._financeNews.observe(viewLifecycleOwner,{
            sportData = it.results as ArrayList<Result>
            financeAdapter.setData(sportData)
            financeAdapter.notifyDataSetChanged()
        })
    }

    override fun onItemClicked(position: Int) {

        var bundle = Bundle()
        bundle.putString("NEWS", position.toString())


        val detailsFragment = Details_Fragment()

//        financeAdapter.financesList[position].results[position]
//        newsAdapter.resiltList[position].imageUrl
//        newsAdapter.resiltList[position].description

        detailsFragment.arguments = bundle

        fragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment,detailsFragment)?.commit()
    }
}


