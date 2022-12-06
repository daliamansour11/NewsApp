package com.example.newsapp.finance.view

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

class FinanceAdapter(var context: Context, listener : onItemClickListener):
    RecyclerView.Adapter<FinanceAdapter.ViewHolder>() {
    var financesList: List<NewsResponse> = ArrayList()
    fun setSportList(financeList: List<NewsResponse>) {
        financesList = financeList

    }

    var finances: List<Result> = ArrayList()
    fun setData(dataList: List<Result>) {
        finances = dataList
    }



    override fun onBindViewHolder(holder: FinanceAdapter.ViewHolder, position: Int) {

        holder.apply {
            val currentItem = finances[position]
            newstitle.text = ("${currentItem.title}")
            new_description.text = ("${currentItem.description}")
            publis_date.text = ("${currentItem.pubDate}")
            //source_name.text= ("${currentItem.sourceId}")
            Glide.with(context).load("${currentItem.imageUrl}")
                .placeholder(R.drawable.ic_launcher_foreground
            )
                .error(R.drawable.ic_baseline_error_outline_24)
                .into(holder.newsImage)
            root_item.setOnClickListener {
                //listener.onItemClicked(currentItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return finances.size
    }

    inner class ViewHolder( itemView: View): RecyclerView.ViewHolder(itemView){
        val newsImage : ImageView = itemView.findViewById(R.id.fimageView)
        val newstitle: TextView = itemView.findViewById(R.id.ftvTitle)
        val new_description  : TextView = itemView.findViewById(R.id.ftvDescription)
        val publis_date  : TextView = itemView.findViewById(R.id.fpublis_date)
        //val source_name  :TextView = item.findViewById(R.id.source_name)
        val root_item : CardView = itemView.findViewById(R.id.fnews_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view =LayoutInflater.from(parent.context).inflate(R.layout.finance_item,parent,false)

        return ViewHolder(view)
//
        }
    }
