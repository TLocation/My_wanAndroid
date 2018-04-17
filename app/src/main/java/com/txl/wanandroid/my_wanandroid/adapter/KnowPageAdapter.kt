package com.txl.wanandroid.my_wanandroid.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseFragment
import com.txl.wanandroid.my_wanandroid.bean.knowledge.KnowledgeBean

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/17 0017 19:19
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class KnowPageAdapter(var fragmentList: List<BaseFragment>, var titleList: List<KnowledgeBean.Data
.Children>, fm:
                      FragmentManager?) :
        FragmentPagerAdapter
        (fm) {

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence = titleList[position].name
}