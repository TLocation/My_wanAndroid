package com.txl.wanandroid.my_wanandroid.net

import android.os.Looper
import com.txl.wanandroid.my_wanandroid.net.cookie.CookieManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

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

/**
 * 单例的声明方式
 */
object MyOkhttp {
    var okHttpClient: OkHttpClient;
    val hanlder: android.os.Handler = android.os.Handler(Looper.getMainLooper())

    init {
        val log = HttpLoggingInterceptor()
        log.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient = OkHttpClient.Builder()
                .cookieJar(CookieManager())
                .addInterceptor(log)
                .build()
    }

    fun get(): GetBuilder = GetBuilder()
    fun post(): PostBuilder = PostBuilder()
}