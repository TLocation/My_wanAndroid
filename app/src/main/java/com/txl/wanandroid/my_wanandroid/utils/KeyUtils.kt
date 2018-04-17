package com.txl.wanandroid.my_wanandroid.utils

/**
 *
 * 项目名称: 药到家
 * 类描述:存放key值
 * 创建人: 田晓龙
 * 创建时间: 2018/4/6 0006 19:52
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


object KeyUtils {
//------------------------------------login--------------------------------------

    //登录用户名
    const val KEY_USERNAME = "username"
    //登录密码
    const val KEY_PASSWORD = "password"

    //--------------------------------------web-----------------------------
    const val WEB_URL = "weburl"
    //--------------------------------------KnowkedgeTabActivity------------------------
    //跳转到知识体系二级页面的title
    const val KNOW_KEY_TITLE = "know_title"
    //知识体系二级页面 cid集合 包含名字  cid
    const val KNOW_KEY_CID = "know_cid"
    //-----------------------------knowPageFragmnet-----------------------------------
    //知识体系分页cid
    const val KNOW_PAGE_KEY_CID = "page_cid"




    //--------------------------------sp-----------------------------------------
    const val IS_LOGIN = "isLogin"
}