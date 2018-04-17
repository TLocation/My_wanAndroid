package com.txl.wanandroid.my_wanandroid.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: YC
 * 创建时间: 2018/4/17 19:37
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class ProjectTabAdapter(fm: FragmentManager?, var fl: ArrayList<Fragment>, var titles: ArrayList<String>) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fl[position]
    }

    override fun getCount(): Int {
        return fl.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}