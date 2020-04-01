package com.kotlin.example.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kotlin.example.R
import com.kotlin.example.data.News
import com.kotlin.example.details.NewsDetailsActivity

/**
 * Created by shishoufeng on 2020-04-01.
 * email:shishoufeng1227@126.com
 *
 *
 * 新闻列表数据
 *
 */
class NewsListAdapter(con: Context) : BaseMultiItemQuickAdapter<News.Data,BaseViewHolder>() {

    private var mContext:Context = con
    private lateinit var mInflater : LayoutInflater

    init {
        mContext = con
        mInflater = LayoutInflater.from(mContext)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            News.TOP ->{
                NewsTopViewHolder(mInflater.inflate(R.layout.item_news_top,parent,false))
            }
            else ->{
                NewsNormalHolder(mInflater.inflate(R.layout.item_news_normal,parent,false))
            }
        }
    }


    override fun convert(holder: BaseViewHolder, item: News.Data) {
        when(holder){

            is NewsTopViewHolder->{


            }
            is NewsNormalHolder ->{

                holder.setText(R.id.tv_news_title,item.title)
                    .setText(R.id.tv_news_source,item.source)

                Glide.with(holder.itemView)
                    .load(item.imgsrc)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(holder.getView(R.id.iv_news_img))

                holder.itemView.setOnClickListener{
                    val intent = Intent()
                    intent.putExtra(NewsDetailsActivity.NEWS_URL,item.url)
                    intent.setClass(mContext,NewsDetailsActivity::class.java)

                    mContext.startActivity(intent)
                }

            }
        }


    }


}

/**
 *
 * 置顶 新闻
 */
class NewsTopViewHolder(view: View) : BaseViewHolder(view)

/**
 *
 * 正常左文右图 类型新闻
 *
 */
class NewsNormalHolder(view: View) : BaseViewHolder(view)