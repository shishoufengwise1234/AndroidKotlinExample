package com.kotlin.example.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

//    private val _newTitls = MutableLiveData<Array<String>>().apply {
//        // 	类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
//        value = arrayOf("头条","社会","国内","guoji","yule","tiyu","junshi","keji","caijing","shishang")
////        )
//    }
//
//    private val _newType = MutableLiveData<Array<String>>().apply {
//        // 	类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
//        value = arrayOf("top","shehui","guonei","guoji","yule","tiyu","junshi","keji","caijing","shishang")
//    }
//
    private val _newsMap = MutableLiveData<Map<String,String>>().apply {
        // 	类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
//        value = arrayOf("top","shehui","guonei","guoji","yule","tiyu","junshi","keji","caijing","shishang")
        value = mapOf(
            Pair("头条","top"),
            Pair("社会","shehui"),
            Pair("国内","guonei"),
            Pair("国际","guoji"),
            Pair("娱乐", "yule"),
            Pair("体育", "tiyu"),
            Pair("军事", "junshi"),
            Pair("科技", "keji"),
            Pair("财经", "caijing"),
            Pair("时尚", "shishang")
            )
    }

//    val newTitls : LiveData<Array<String>> = _newTitls
//    val newType : LiveData<Array<String>> = _newType


    val newsMap : LiveData<Map<String,String>> = _newsMap

}