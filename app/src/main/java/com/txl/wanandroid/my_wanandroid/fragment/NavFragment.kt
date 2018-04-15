package com.txl.wanandroid.my_wanandroid.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.adapter.NavAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseFragment
import com.txl.wanandroid.my_wanandroid.bean.nav.NavDataBean
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import com.txl.wanandroid.my_wanandroid.net.response.GsonResponse
import com.txl.wanandroid.my_wanandroid.utils.UrlUtils
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_nav.*

/**
 *
 * 项目名称: WanAndroid
 * 类描述:  导航fragmnet
 * 创建人: 田晓龙
 * 创建时间: 2018/4/12 0012 16:54
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class NavFragment : BaseFragment(), AdapterView.OnItemClickListener {

    val listData: ArrayList<NavDataBean.Data> by lazy { ArrayList<NavDataBean.Data>() }
    override fun getLayoutId(): Int {
        return R.layout.fragment_nav
    }

    val adapter: NavAdapter by lazy {
        NavAdapter(R.layout.item_nav, listData, this)
    }

    override fun init() {
        navRecyclerView.layoutManager = LinearLayoutManager(activity)
        navRecyclerView.adapter = adapter
    }

    override fun loadData() {
        MyOkhttp.get()
                .url(UrlUtils.NAV_ARTICLE)
                .enqueue(object : GsonResponse<NavDataBean>() {
                    override fun onFeail(statCode: Int, errorMsg: String?) {

                    }

                    override fun onSuccful(statCode: Int, response: NavDataBean) {
                        adapter.refresh(response.data)
                        listData.apply {
                            clear()
                            addAll(response.data)
                        }
                        Observable.fromIterable(response.data[0].articles)
                                .subscribe {
                                    navFlowLayout.addView(it.let {
                                        val textview = TextView(activity)
                                        textview.text = it.title
                                        textview
                                    })

                                }
                    }
                })
    }

    override fun onItemClick(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
        navFlowLayout.removeAllViews()
        Observable.fromIterable(listData[position].articles)
                .subscribe {
                    val textview = TextView(activity)
                    textview.text = it.title
                    textview.setPadding(10,10,10,10)
                    textview.setBackgroundResource(R.drawable.select_nav_flow_item)
                    navFlowLayout.addView(textview)
                }
    }

}