package com.example.newsapp.details.view

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.home.view.NewsAdapter
import com.example.newsapp.home.view.homeFragment
import com.example.newsapp.home.view.onItemClickListener


class Details_Fragment : Fragment(),onItemClickListener {
lateinit var dTittle:TextView
lateinit var news_img :ImageView
lateinit var news_des:TextView
lateinit var back_btn:ImageView
lateinit var newsAdapter :NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsAdapter = NewsAdapter(requireContext(),this)

        dTittle=view.findViewById(R.id.details_tvTitle)
        news_img=view.findViewById(R.id.details_imageView)
        news_des=view.findViewById(R.id.details_tvDescription)
        back_btn=view.findViewById(R.id.back_details)
            var args = this.arguments
        var bundle=Bundle()

        var tittle = args?.getString("NEWSTITTLE")
        var description = args?.getString("NEWSDES")
        var img = args?.getString("NEWSIMG")
//        var position:Int
//        Glide.with(requireContext()).load("${newsAdapter.resiltList[position].imageUrl}")
//            .placeholder(R.drawable.ic_launcher_foreground)
//            .error(R.drawable.ic_baseline_error_outline_24)
//            .into(news_img)
         //  news_img.setImageResource(img!!.toInt())
//        val bitmap = BitmapFactory.decodeFile(img)
//        news_img.setImageBitmap(bitmap)
        Log.i("image1", "onViewCreated: ")


        dTittle.text= tittle
        news_des .text= description
//
 back_btn.setOnClickListener({
     val homeFragment = homeFragment()

     fragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment,homeFragment)?.commit()

 })

    }

    companion object {

        @JvmStatic
        fun newInstance( ) =
            Details_Fragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onItemClicked(position: Int) {
        TODO("Not yet implemented")
    }
}