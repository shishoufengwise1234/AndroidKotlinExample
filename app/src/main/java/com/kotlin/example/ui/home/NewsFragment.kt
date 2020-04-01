package com.kotlin.example.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.example.R
import com.kotlin.example.adapter.NewsListAdapter
import com.kotlin.example.base.BaseFragment
import com.kotlin.example.base.CommonUI
import com.kotlin.example.data.News
import com.kotlin.example.net.EasyHttp
import com.kotlin.example.utils.logI
import kotlinx.android.synthetic.main.layout_recyclerview.*

/**
 * Created by shishoufeng on 2020-03-31.
 * email:shishoufeng1227@126.com
 *
 *
 * 新闻页面
 *
 */
class NewsFragment :BaseFragment(){

    private var param: String = ""
    private lateinit var mAdapter:NewsListAdapter

    public fun newInstance(type: String):NewsFragment{
        val instance = NewsFragment()
        instance.param = type

        return instance
    }


    override fun getLayoutResId(): Int {
        return R.layout.fragment_news
    }

    override fun initView(rootView: View?) {



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mAdapter = NewsListAdapter(activity as Context)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(
            DividerItemDecoration(activity,
                DividerItemDecoration.VERTICAL)
        )
        recyclerView.adapter = mAdapter

        loadData()

    }

    private fun loadData() {

        val net = EasyHttp()

        net.getNews(param, object : EasyHttp.NetCallBack<News> {
            override fun onSuccess(t: News) {

                logI(TAG,"t = $t")

                CommonUI.Instance.mHandler.post {



                    mAdapter?.setList(t?.T1348647853363)
                    mAdapter?.notifyDataSetChanged()
                }


            }

            override fun onError(t: Throwable) {

                logI(TAG,"t = ${t.message}")

            }

        })
    }

    override fun initData() {


    }

}