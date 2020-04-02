package com.kotlin.example.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.example.R
import com.kotlin.example.data.News
import com.kotlin.example.details.NewsDetailsActivity

/**
 * Created by shishoufeng on 2020-04-01.
 * email:shishoufeng1227@126.com
 *
 *
 * 新闻适配器
 *
 */
class NewsAdapter(con: Context,list: List<News.Data>) : RecyclerView.Adapter<NewsViewHolder>(){


    private var mContext:Context = con
    private lateinit var mInflater : LayoutInflater
    private var mList:List<News.Data> = list

    init {
        mContext = con
        mInflater = LayoutInflater.from(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = mInflater.inflate(R.layout.item_news_normal,parent,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        val data = mList.get(position) ?: return

        holder.tvTitle?.text = data.title
        holder.tvSource?.text = data.source

        Glide.with(holder.itemView)
            .load(data.imgsrc)
            .placeholder(R.drawable.ic_default_image)
            .error(R.drawable.ic_default_image)
            .fallback(R.drawable.ic_default_image)
            .centerCrop()
            .into(holder.ivNewsPic!!)

        holder.llNewsGroup?.setOnClickListener{
            val intent = Intent()
            intent.putExtra(NewsDetailsActivity.NEWS_URL,data.url)
            intent.setClass(mContext, NewsDetailsActivity::class.java)

            mContext.startActivity(intent)
        }

    }


}

class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    var llNewsGroup : RelativeLayout? = null
    var ivNewsPic : ImageView? = null
    var tvTitle : TextView? = null
    var tvSource : TextView? = null

    init {
        llNewsGroup = itemView.findViewById(R.id.rl_news_group)
        ivNewsPic = itemView.findViewById(R.id.iv_new_img)
        tvTitle = itemView.findViewById(R.id.tv_news_title)
        tvSource = itemView.findViewById(R.id.tv_news_source)

    }
}