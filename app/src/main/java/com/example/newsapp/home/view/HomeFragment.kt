package com.example.newsapp.home.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.newsapp.Constant
import com.example.newsapp.R
import com.example.newsapp.details.view.Details_Fragment
import com.example.newsapp.home.model.Result
import com.example.newsapp.home.viewModel.HomeViewModel
import com.example.newsapp.home.viewModel.HomeViewModelFactoryon
import com.example.newsapp.network.Api
import com.example.newsapp.repository.HomeRepository
import kotlin.streams.toList
class homeFragment : Fragment(),onItemClickListener {
    lateinit var homeViewModel: HomeViewModel

    // val catgoryList = listOf<String>("politics","science","health" ,"business","sports","technology",)
    //val countryList = listOf<String>(" eg" )
    lateinit var searchView: SearchView
    var tabLayout: TableLayout? = null
    var viewPager: ViewPager? = null
    lateinit var recyclerView: RecyclerView
    lateinit var newsAdapter: NewsAdapter
    var searchQueryText = ""
    var data: ArrayList<Result> = ArrayList()

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
        var home_fragment =  inflater.inflate(R.layout.fragment_home, container, false)
          searchView = home_fragment.findViewById(R.id.search_view)
      return  home_fragment
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     //   initUI(view)
//        newsAdapter = NewsAdapter(requireContext(),data,this)
//        recyclerView.adapter = newsAdapter
        recyclerView = view.findViewById(R.id.news_recyclerView)
        newsAdapter = NewsAdapter(requireContext(),this)
        recyclerView.adapter = newsAdapter
        val repository = HomeRepository(Api.apiService)
        homeViewModel= ViewModelProvider(this,HomeViewModelFactoryon(repository)).get(HomeViewModel::class.java)
        homeViewModel.getHomeNews(Constant.API_KEY,Constant.LANG)
        homeViewModel._mnews_reponse.observe(viewLifecycleOwner,{
            Log.i("TAG", "onViewCreated: ${it}")
              data = it.results as ArrayList<Result>
            newsAdapter.setList(data)

        })
        searchView.setOnQueryTextListener(object:android.widget.SearchView.OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                     searchQueryText = query
                    var filteredProductList = filterData(query)
                    newsAdapter.setList(filteredProductList)
                    newsAdapter.notifyDataSetChanged()
                    searchView.clearFocus()
                    return true
                }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null && newText.length==0) {
                    searchQueryText = newText
                    newsAdapter.setList(data)
                    newsAdapter.notifyDataSetChanged()
                    searchView.clearFocus()
                    return true
                }
                return false
            }
        })
    }

    private fun filterData(query: String): List<Result> {
        var filteredProductList = data.stream().filter { product ->
            product.title!!.lowercase().contains(query.lowercase())

        }.toList()
        return filteredProductList
    }
 fun initUI(view: View){

 }
    override fun onItemClicked(position: Int) {
        var bundle = Bundle()
        var tittle = newsAdapter.resiltList[position].title
        var description = newsAdapter.resiltList[position].description
        var img = newsAdapter.resiltList[position]



        bundle.putString("NEWSTITTLE", tittle.toString())
        bundle.putString("NEWSDES", description.toString())
        bundle.putString("NEWSIMG", img.toString())
        val detailsFragment = Details_Fragment()
        detailsFragment.arguments = bundle
        fragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment,detailsFragment)?.commit()
    }

}