package com.kotlin.example.utils

import android.util.Log

/**
 * Created by shishoufeng on 2020-03-31.
 * email:shishoufeng1227@126.com
 *
 * 相关工具类
 *
 *
 */

const val COMMON_TAG = "example_common_log : "

fun logI(msg: String) {
    Log.i(COMMON_TAG, msg)
}

fun logI(tag: String, msg: String) {
    Log.i(COMMON_TAG + tag, msg)
}


fun logE(msg: String) {
    Log.e(COMMON_TAG, msg)
}

fun logE(tag: String, msg: String) {
    Log.e(COMMON_TAG + tag, msg)
}


