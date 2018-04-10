package com.txl.wanandroid.my_wanandroid.fragment

import com.txl.wanandroid.my_wanandroid.R
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
class HomeFragment : BaseFragment() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun init() {

        fragment_home_rll
    }

    override fun loadData() {

        MyOkhttp.get().url(UrlUtils.GET_HOME_ARTICLE_LIST(0)).enqueue(object : GsonResponse<HomeList>() {
            override fun onFeail(statCode: Int, errorMsg: String?) {
                toast(errorMsg!!)
            }

            override fun onSuccful(statCode: Int, response: HomeList) {
                toast(response.toString())
            }

        })

    }
}