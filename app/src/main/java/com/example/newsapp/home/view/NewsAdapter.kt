package com.example.newsapp.home.view

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

class NewsAdapter(var context: Context,val listener :onItemClickListener) : RecyclerView.Adapter<NewsAdapter.ViewHolder> (){

    private var newsList:List<NewsResponse>  = arrayListOf()
    var resiltList: List<Result> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
     val view =   LayoutInflater.from(parent.context).inflate(R.layout.news_row,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
    holder.apply {
      val currentItem =  resiltList[position]
        newstitle.text = ("${currentItem.title}")
        new_description.text = ("${currentItem.description}")
        publis_date.text= ("${currentItem.pubDate}")
        //source_name.text= ("${currentItem.sourceId}")
        Glide.with(context).load("${currentItem.imageUrl}")
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(holder.newsImage)
        root_item.setOnClickListener{
            listener.onItemClicked(currentItem)
        }
    }
     }
    internal fun setDataList(dataList:List<NewsResponse>){
        newsList = dataList
    }
    fun setList(mList: List<Result>){
       this.resiltList = mList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return resiltList.size
    }
    inner  class ViewHolder(item: View):RecyclerView.ViewHolder(item){
        val newsImage :ImageView = item.findViewById(R.id.imageView)
        val newstitle: TextView = item.findViewById(R.id.tvTitle)
        val new_description  :TextView = item.findViewById(R.id.tvDescription)
        val publis_date  :TextView = item.findViewById(R.id.publis_date)
        //val source_name  :TextView = item.findViewById(R.id.source_name)
        val root_item : CardView = item.findViewById(R.id.news_item)

    }
}
