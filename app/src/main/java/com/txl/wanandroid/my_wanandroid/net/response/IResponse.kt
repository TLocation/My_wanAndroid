package com.txl.wanandroid.my_wanandroid.net.response

import okhttp3.Response

/**
 *
 * 项目名称: 药到家
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/4 0004 22:52
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


interface IResponse {

    fun onSuccful(response: Response)

    fun onFeail(statCode: Int, errorMsg: String?)
}