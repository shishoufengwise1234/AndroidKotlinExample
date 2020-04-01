package com.kotlin.example.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _newsMap = MutableLiveData<Map<String,String>>().apply {
        // 	类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
        value = mapOf(
            Pair("头条","http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html"),
            Pair("精选","http://c.3g.163.com/nc/article/list/T1467284926140/0-20.html"),
            Pair("娱乐","http://c.3g.163.com/nc/article/list/T1348648517839/0-20.html"),
            Pair("汽车","http://c.m.163.com/nc/auto/list/5bmz6aG25bGx/0-20.html"),
            Pair("运动", "http://c.3g.163.com/nc/article/list/T1348649079062/0-20.html")
//            Pair("头条","top"),
//            Pair("社会","shehui"),
//            Pair("国内","guonei"),
//            Pair("国际","guoji"),
//            Pair("娱乐", "yule"),
//            Pair("体育", "tiyu"),
//            Pair("军事", "junshi"),
//            Pair("科技", "keji"),
//            Pair("财经", "caijing"),
//            Pair("时尚", "shishang")
            )
    }

    val newsMap : LiveData<Map<String,String>> = _newsMap

}