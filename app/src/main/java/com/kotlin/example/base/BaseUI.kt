package com.kotlin.example.base

import android.app.Application
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.multidex.MultiDex

/**
 * Created by shishoufeng on 2020-03-31.
 * email:shishoufeng1227@126.com
 *
 *
 * 抽象 UI 层简单封装
 *
 */
abstract class BaseFragment : Fragment(){

    protected val TAG = this.javaClass.simpleName


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(getLayoutResId(),container,false)

        initView(rootView)

        initData()

        return rootView
    }




    @LayoutRes
    abstract fun getLayoutResId():Int


    abstract fun initView(rootView: View?)


    abstract fun initData()

}

class CommonUI private constructor(){

    val mHandler = Handler(Looper.getMainLooper())

    companion object{
        val Instance = CommonUIHolder.mCommonUI
    }


    fun getAppHandler(): Handler {
        return mHandler
    }


    private object CommonUIHolder{
        val mCommonUI = CommonUI()
    }

}



class ExampleApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)

    }
}