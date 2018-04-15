package com.txl.wanandroid.my_wanandroid.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: YC
 * 创建时间: 2018/4/16 0:05
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class HomeVpAdapter(var context: Context, var imgs: List<String>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return Int.MAX_VALUE
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var iv = ImageView(context)
        Glide.with(context).load(imgs[position % imgs.size]).into(iv)
        container.addView(iv)
        return iv
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}