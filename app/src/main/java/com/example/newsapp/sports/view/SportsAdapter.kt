package com.example.newsapp.sports.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.home.model.NewsResponse
import com.example.newsapp.home.model.Result
import com.example.newsapp.home.view.onItemClickListener

class SportsAdapter(var context: Context,listener :onItemClickListener):RecyclerView.Adapter<SportsAdapter.ViewHolder>() {
   var sportsList: List<NewsResponse> = ArrayList()
    fun setSportList (sportList :List<NewsResponse>){
        sportsList = sportList

    }
    var sports :List<Result> = ArrayList()
    fun setData(dataList:List<Result>){
        sports = dataList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsAdapter.ViewHolder {
        val view =   LayoutInflater.from(parent.context).inflate(R.layout.sports_item,parent,false)
  return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportsAdapter.ViewHolder, position: Int) {

        holder.apply {
            val currentItem =  sports[position]
            newstitle.text = ("${currentItem.title}")
            new_description.text = ("${currentItem.description}")
            publis_date.text= ("${currentItem.pubDate}")
            //source_name.text= ("${currentItem.sourceId}")
            Glide.with(context).load("${currentItem.imageUrl}")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_baseline_error_outline_24)
                .into(holder.newsImage)
            root_item.setOnClickListener{
                //listener.onItemClicked(currentItem)
            }
        }
    }
    override fun getItemCount(): Int {
      return sports.size
    }
    inner class ViewHolder( itemView: View):RecyclerView.ViewHolder(itemView){
    val newsImage : ImageView = itemView.findViewById(R.id.imageView)
    val newstitle: TextView = itemView.findViewById(R.id.tvTitle)
    val new_description  : TextView = itemView.findViewById(R.id.tvDescription)
    val publis_date  : TextView = itemView.findViewById(R.id.publis_date)
    //val source_name  :TextView = item.findViewById(R.id.source_name)
    val root_item : CardView = itemView.findViewById(R.id.news_item)
}}