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
     * 首页文章列表
     */
    val GET_HOME_ARTICLE_LIST = { page: Int -> BASE_URL + "article/list/$page/json" }
    /**
     * 首页轮播图
     */
    const val HOME_BANNER = "${BASE_URL}banner/json"

    /**
     *
     * 首页列表
     */

    const val GET_KNOWLEDGE_LIST = "${BASE_URL}tree/json"

    /**
    *
    * 项目table
    */
    const val PROJECT_TABLE = "${BASE_URL}project/tree/json"

    /**
     * 导航文章
     */
    const val NAV_ARTICLE = "${BASE_URL}navi/json"

}