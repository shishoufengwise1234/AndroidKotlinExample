package com.kotlin.example.ui.home

import android.view.View
import com.kotlin.example.R
import com.kotlin.example.base.BaseFragment
import com.kotlin.example.data.NewsData
import com.kotlin.example.net.EasyHttp
import com.kotlin.example.utils.logI

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

    override fun initData() {

        val net = EasyHttp()

        net.getNews(param, object :EasyHttp.NetCallBack<NewsData> {
            override fun onSuccess(t: NewsData) {

                logI(TAG,"t = $t")
            }

            override fun onError(t: Throwable) {


            }

        })
    }

}