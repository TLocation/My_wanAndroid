package com.txl.wanandroid.my_wanandroid.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.adapter.HomeListAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseFragment
import com.txl.wanandroid.my_wanandroid.bean.home.HomeList
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import com.txl.wanandroid.my_wanandroid.net.response.GsonResponse
import com.txl.wanandroid.my_wanandroid.utils.UrlUtils
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 项目名称：玩Android
 * 类描述：
 *
 * Created by YC on 2018/4/7 21:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
class HomeFragment : BaseFragment(), AdapterView.OnItemClickListener {

    lateinit var homeList: ArrayList<HomeList.Data.Data>

    lateinit var listAdapter: HomeListAdapter

    var PAGE: Int = 0

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun init() {

        homeList = ArrayList()

        var manager = LinearLayoutManager(activity)

        manager.orientation = LinearLayoutManager.VERTICAL

        fragment_home_rll.layoutManager = manager

        listAdapter = HomeListAdapter(R.layout.home_list_item, homeList, this)
//        var wrapper = RecyclerViewWrapper<HomeList.Data.Data>(listAdapter )
        val view = LayoutInflater.from(activity).inflate(R.layout.home_header_vp, null)
        listAdapter.addHeaderView(view)
        fragment_home_rll.adapter = listAdapter


    }

    override fun loadData() {

        MyOkhttp.get()
                .url(UrlUtils.GET_HOME_ARTICLE_LIST(PAGE)).enqueue(object : GsonResponse<HomeList>() {
            override fun onFeail(statCode: Int, errorMsg: String?) {
                toast(errorMsg!!)
            }

            override fun onSuccful(statCode: Int, response: HomeList) {
                homeList.addAll(response.data.datas)

                listAdapter.refresh(homeList)
            }

        })

    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        toast("跳转...$p2")

    }
}