package com.kotlin.example.net

import com.google.gson.Gson
import com.kotlin.example.data.News
import com.kotlin.example.utils.logE
import com.kotlin.example.utils.logI
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by shishoufeng on 2020-03-31.
 * email:shishoufeng1227@126.com
 *
 *
 *  简单封装 OKhttp 使用
 *
 * https://github.com/square/okhttp
 *
 *
 */
class EasyHttp {

    val TAG = "EasyHttp"


    val mOkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30 * 1000L, TimeUnit.MILLISECONDS)
        .readTimeout(30 * 1000L, TimeUnit.MILLISECONDS)
        .writeTimeout(30 * 1000L, TimeUnit.MILLISECONDS)
//        .hostnameVerifier(HostnameVerifier { hostname, session -> true })
        .build()

    val mGson = Gson()


    fun get(url : String,callback : NetCallBack<String>){

        val request = Request.Builder()
            .get()
            .url(url)
            .build()

        mOkHttpClient.newCall(request)
            .enqueue(object:Callback{

                override fun onFailure(call: Call, e: IOException) {
                    logI(TAG,"get() -> onFailure() ${e.message}")

                    call.cancel()

                    callback.onError(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    logI(TAG,"get() -> onResponse() ")

                    response.body?.string()?.let {
                        callback.onSuccess(it)
                    }
                }
            })

    }


    /**
     *
     * 获取 新闻数据
     *
     */
    fun getNews(url:String?,callback: NetCallBack<News>){

        // 拼接 请求地址
//        val reqUrl = "http://v.juhe.cn/toutiao/index?key=${Constants.APP_KEY}&type=${type ?: "top"}"
        // 请求URL
        val reqUrl = url ?: "http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html"

        logI(TAG,"getNews() reqUrl = $reqUrl ")

        get(reqUrl,object :NetCallBack<String>{

            override fun onError(t: Throwable) {
                logI(TAG,"getNews() -> onError() t = ${t.message}")

                callback?.onError(t)
            }

            override fun onSuccess(t: String) {

                logI(TAG,"getNews() -> onSuccess() data = $t")

                val newsData : News = if (t.contains("<html>")){
                    logE(TAG,"getNews() -> onSuccess() 数据不正确")

                    News()
                }else{
                    logI(TAG,"getNews() -> onSuccess() 数据正确 可以解析")

                    mGson.fromJson(t,News::class.java)
                }

                callback?.onSuccess(newsData)

            }
        })

    }



    interface NetCallBack<T>{

        fun onSuccess(t : T)

        fun onError(t: Throwable)
    }


}