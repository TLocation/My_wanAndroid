package com.txl.wanandroid.my_wanandroid.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 *
 * 项目名称: WanAndroid
 * 类描述:  基础Fragment
 * 创建人: 田晓龙
 * 创建时间: 2018/4/7 0007 16:36
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


abstract class BaseFragment : Fragment() {
    protected val TAG = javaClass.simpleName
    protected lateinit var activity: BaseActivity
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        loadData()
    }

    /**
     * 高阶函数 为fragment 增加toast方法
     */
    fun Fragment.toast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun init()

    abstract fun loadData()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as BaseActivity
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) onHide() else onShow()
    }

    fun onShow() {}
    fun onHide() {}
}