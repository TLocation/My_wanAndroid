package com.txl.wanandroid.my_wanandroid.base

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/7 0007 16:44
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class BaseFragmentBuilder() {
    lateinit var transaction: FragmentTransaction
    lateinit var simpletName: String
    lateinit var fragment: BaseFragment
    val fragmentMap: HashMap<Int, BaseFragment> by lazy { HashMap<Int, BaseFragment>() }


    companion object {
        private val instance = BaseFragmentBuilder()
        private lateinit var manager: FragmentManager
        fun getInstance(baseActivity: BaseActivity? = null, baseFragment: BaseFragment? = null): BaseFragmentBuilder {
            manager = baseActivity?.supportFragmentManager ?: baseFragment!!.childFragmentManager
            return instance
        }
    }

    fun start(cla: Class<out BaseFragment>): BaseFragmentBuilder {
        transaction = manager.beginTransaction()
        simpletName = cla.simpleName!!
        fragment = manager.findFragmentByTag(simpletName) as? BaseFragment ?: cla.newInstance()!!
        return this
    }

    fun add(resid: Int): BaseFragmentBuilder {
        if (manager.findFragmentByTag(simpletName) == null) transaction.add(resid, fragment, simpletName)
        fragmentMap.get(resid)?.let { transaction.hide(it) }
        transaction.show(fragment)
        fragmentMap.put(resid, fragment)
        return this
    }

    fun addToback(): BaseFragmentBuilder {
        transaction.addToBackStack(simpletName)
        return this
    }

    fun commit() {
        transaction.commit()
    }


}