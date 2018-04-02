package com.txl.wanandroid.my_wanandroid.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.gyf.barlibrary.ImmersionBar

/**
 *
 * 项目名称: 药到家
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/3/29 0029 21:20
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


abstract class BaseActivity : AppCompatActivity() {
    protected val TAG = javaClass.simpleName
    lateinit var immersionBar: ImmersionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        immersionBar = ImmersionBar.with(this)
        immersionBar.init()
        initView()
        loadData()
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun initView()

    protected abstract  fun loadData()


    override fun onDestroy() {
        super.onDestroy()
        immersionBar.destroy()
    }
}