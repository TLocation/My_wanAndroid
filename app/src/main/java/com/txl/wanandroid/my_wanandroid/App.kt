package com.txl.wanandroid.my_wanandroid

import android.app.Application
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


class App :Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceUtils.setContext(applicationContext)
    }
}