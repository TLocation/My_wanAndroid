package com.txl.wanandroid.my_wanandroid.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
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
    /**
     * 常亮 val  变量 var
     *
     */
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

    /**
     * 方法申明  fun  格式  fun 名字（）：返回值
     * 这个方法返回值为int类型
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int

    /**
     * 方法申明  fun  格式  fun 名字（）：返回值
     */
    protected abstract fun initView()

    protected abstract fun loadData()


    /**
     * 重写方法  需要加override 参数
     */
    override fun onDestroy() {
        super.onDestroy()
        immersionBar.destroy()
    }


    fun Context.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


    }

    fun  Context.log(message: String){
        Log.e(TAG, message)
    }
    fun startActivity(cla:Class<out BaseActivity>){
        startActivity(Intent(this,cla))
    }





}