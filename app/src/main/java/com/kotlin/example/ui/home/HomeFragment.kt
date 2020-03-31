package com.kotlin.example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlin.example.R
import com.kotlin.example.adapter.NewsFragmentAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        initView()

        return root
    }

    private fun initView() {

        homeViewModel.newsMap.observe(this, Observer {

            val titles = it.keys.toTypedArray()

            val list = ArrayList<NewsFragment>(it.size)

            // 组装fragment集合
            for (en in it.entries){
                list.add(NewsFragment().newInstance(en.value))
            }

            viewPager.adapter = NewsFragmentAdapter(childFragmentManager,list)
            tabLayout.setViewPager(viewPager,titles)


        })


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)





    }
}