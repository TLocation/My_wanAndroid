package com.txl.wanandroid.my_wanandroid.fragment

import android.support.v4.app.Fragment
import android.util.Log
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.adapter.ProjectTabAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseFragment
import com.txl.wanandroid.my_wanandroid.bean.project.ProjectTabBean
import com.txl.wanandroid.my_wanandroid.fragment.project.ProjectVpFragment
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import com.txl.wanandroid.my_wanandroid.net.response.GsonResponse
import com.txl.wanandroid.my_wanandroid.utils.UrlUtils
import kotlinx.android.synthetic.main.fragment_project.*

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/13 0013 16:01
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class ProjectFragment : BaseFragment() {

    lateinit var tabBean: ArrayList<ProjectTabBean.Data>

    override fun getLayoutId(): Int {
        return R.layout.fragment_project
    }

    override fun init() {

        tabBean = ArrayList()


    }

    override fun loadData() {

        MyOkhttp.get().url(UrlUtils.PROJECT_TABLE).enqueue(object : GsonResponse<ProjectTabBean>() {
            override fun onFeail(statCode: Int, errorMsg: String?) {
                toast(errorMsg.toString())
            }

            override fun onSuccful(statCode: Int, response: ProjectTabBean) {

                tabBean.addAll(response.data)

            }

        })

        var titles = ArrayList<String>()

        for (tab in tabBean) {

            titles.add(tab.name)

            Log.e("title", tab.name)
        }

        project_vp.offscreenPageLimit = 3

        var fl = ArrayList<Fragment>()

        for (fragment in titles) {

            fl.add(ProjectVpFragment())

        }

        var adapter = ProjectTabAdapter(this.fragmentManager, fl, titles)

        project_vp.adapter = adapter

        project_tab.setupWithViewPager(project_vp)

    }
}