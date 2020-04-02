package com.kotlin.example.ui.home

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.example.R
import com.kotlin.example.adapter.NewsAdapter
import com.kotlin.example.base.BaseFragment
import com.kotlin.example.base.CommonUI
import com.kotlin.example.data.News
import com.kotlin.example.net.EasyHttp
import com.kotlin.example.utils.logI
import com.scwang.smartrefresh.header.WaterDropHeader
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.layout_recyclerview.*

/**
 * Created by shishoufeng on 2020-03-31.
 * email:shishoufeng1227@126.com
 *
 *
 * 新闻页面
 *
 */
class NewsFragment : BaseFragment() {

    var param: String = ""
    private lateinit var mAdapter: NewsAdapter
    private var mData = ArrayList<News.Data>(10)


    override fun getLayoutResId(): Int {
        return R.layout.fragment_news
    }

    override fun initView(rootView: View?) {
        logI(TAG, "initView() param = $param")

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mAdapter = NewsAdapter(activity as Context, mData)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.adapter = mAdapter


        smartRefresh.setEnableAutoLoadMore(false)
        smartRefresh.setEnableLoadMore(false)
        smartRefresh.setRefreshHeader(WaterDropHeader(activity))
        smartRefresh.autoRefresh()

        smartRefresh.setOnRefreshListener {

            loadData()
        }

    }

    private fun loadData() {

        EasyHttp().getNews(param, object : EasyHttp.NetCallBack<News> {
            override fun onSuccess(t: News) {

                logI(TAG, "t = $t")

                CommonUI.Instance.mHandler.post {

                    smartRefresh.finishRefresh()

                    t.T1348647853363?.let {
                        mData.clear()

                        mData.addAll(it)
                    }

//                    mAdapter?.setList(t?.T1348647853363)
                    mAdapter?.notifyDataSetChanged()
                }


            }

            override fun onError(t: Throwable) {

                logI(TAG, "t = ${t.message}")

                CommonUI.Instance.mHandler.post {

                    smartRefresh.finishRefresh()

                    val toast = Toast.makeText(activity, "加载失败", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()

                }

            }

        })
    }

    override fun initData() {


    }

}
