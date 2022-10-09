package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.newsapp.home.view.homeFragment

class DetailsFragment : Fragment() {

    var newstitle = ""
    var newsdes = ""
    var newsimge = ""
    lateinit var details_tv: TextView
    lateinit var details_description: TextView
    lateinit var details_image: ImageView
    lateinit var backArrow: ImageView
    lateinit var detailstext: TextView
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
        var detailsFragment = inflater.inflate(R.layout.fragment_details, container, false)
//        details_tv = detailsFragment.findViewById(R.id.dextails_title)
//        details_description = detailsFragment.findViewById(R.id.details_desc_txt)
       backArrow = detailsFragment.findViewById(R.id.detailsArrowBack)
        detailstext = detailsFragment.findViewById(R.id.detail_text)

        var args = this.arguments
        if (args == null) {
        } else {
            newstitle = args?.get("NEWS") as String
            Log.i("TAG", "onViewCreatedmmmmmmmmmmmmmmmmmmmmmmm: ${newstitle}")
        }
        return detailsFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         backArrow.setOnClickListener{
           val homeFragment = homeFragment()
           fragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment,homeFragment)?.commit() }
         }

    }
