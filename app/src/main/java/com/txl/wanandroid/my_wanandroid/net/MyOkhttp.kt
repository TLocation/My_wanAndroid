package com.txl.wanandroid.my_wanandroid.net

import android.os.Looper
import okhttp3.OkHttpClient

/**
 *
 * 项目名称: 药到家
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/3/30 0030 3:04
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


object MyOkhttp {
    lateinit var okHttpClient: OkHttpClient;
    val hanlder: android.os.Handler = android.os.Handler(Looper.getMainLooper())

    init {
        okHttpClient = OkHttpClient.Builder()
                .build()
    }

}