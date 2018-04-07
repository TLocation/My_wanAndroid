package com.txl.wanandroid.my_wanandroid.net

import com.txl.wanandroid.my_wanandroid.net.response.IResponse
import okhttp3.Request

/**
 *
 * 项目名称: 药到家
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/4 0004 22:34
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class GetBuilder : QuestBuilder<GetBuilder>() {
    override fun enqueue(iResponse: IResponse) {
        var builder = Request.Builder()
        if (params.size > 0) url = append(url, params)
        builder.url(url)
        appendHeaders(builder,headlers)
        builder.get()
        MyOkhttp.okHttpClient.newCall(builder.build()).enqueue(MyCallBack(iResponse))
    }

    private fun append(url: String, params: HashMap<String, String>): String {
        val builder = StringBuilder()

        return builder.apply {
            builder.append(url + "?")
            for ((key, value) in params) {
                append(key)
                append("=")
                append(value)
                append("&")
            }
        }.deleteCharAt(builder.length - 1).toString()

    }


}