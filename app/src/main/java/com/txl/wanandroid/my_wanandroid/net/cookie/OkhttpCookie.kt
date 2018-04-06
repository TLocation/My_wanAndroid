package com.txl.wanandroid.my_wanandroid.net.cookie

import okhttp3.Cookie

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/7 0007 0:57
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


data class OkhttpCookie(var cookies:Cookie, var clientCookies: Cookie?){
    constructor(cookies: Cookie) : this(cookies,null)
}
