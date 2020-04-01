package com.kotlin.example.details

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.example.R
import com.kotlin.example.utils.logI
import kotlinx.android.synthetic.main.activity_news_details.*

/**
 * Created by shishoufeng on 2020-03-31.
 * email:shishoufeng1227@126.com
 *
 *
 * 新闻详情页面
 *
 */
class NewsDetailsActivity :AppCompatActivity(){

    val TAG = "NewsDetailsActivity"

    private lateinit var mNewsUrl : String

    companion object{
        const val NEWS_URL = "news_url"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        initWebView()

        mNewsUrl = intent.getStringExtra(NEWS_URL)

        logI(TAG,"mNewsUrl = $mNewsUrl")

        webview.loadUrl(mNewsUrl)

    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        webview.settings.javaScriptEnabled = true
        webview.settings.setSupportZoom(false)
        webview.settings.useWideViewPort = false

    }
}