package com.txl.wanandroid.my_wanandroid.utils

/**
 *
 * 项目名称: WanAndroid
 * 类描述:存放网址
 * 创建人: 田晓龙
 * 创建时间: 2018/4/6 0006 19:53
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


object UrlUtils {

    private const val BASE_URL = "http://www.wanandroid.com/"

    /**
     * 登录
     */
    const val LOGIN_URL = BASE_URL + "user/login"


    /**
     * 我的收藏列表
     */
    val GET_LIKE_LIST = { page: Int -> BASE_URL + "lg/collect/list/$page/json" }

    /**
     * /article/list/page/json
     */

    val GET_HOME_LIST = { page: Int -> BASE_URL + "article/list/$page/json" }


}