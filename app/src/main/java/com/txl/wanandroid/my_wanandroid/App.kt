package com.txl.wanandroid.my_wanandroid

import android.app.Application
import android.support.multidex.MultiDexApplication
import com.txl.wanandroid.my_wanandroid.utils.PreferenceUtils

/**
 *
 * 项目名称: 药到家
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/6 0006 17:18
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        app = this
        PreferenceUtils.setContext(applicationContext)
    }

    companion object {
        var app: App? = null
        fun getInstance() = app
    }
}