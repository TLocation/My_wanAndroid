package com.txl.wanandroid.my_wanandroid.net

import com.txl.wanandroid.my_wanandroid.net.response.IResponse
import okhttp3.FormBody
import okhttp3.Request

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/6 0006 20:15
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class PostBuilder : QuestBuilder<PostBuilder>() {
    override fun enqueue(iResponse: IResponse) {

        if (url.isNullOrEmpty()) {
            throw RuntimeException("请检查url")
        }
        var builder = Request.Builder()
        builder.apply {
            url(url)
            var bodyBuilder = FormBody.Builder()
            appendParams(bodyBuilder, params)
            appendHeaders(builder, headlers)
            post(bodyBuilder.build())
        }
        MyOkhttp.okHttpClient.newCall(builder.build()).enqueue(MyCallBack(iResponse))

    }

    fun appendParams(builder: FormBody.Builder, params: HashMap<String, String>) {

        for ((key, value) in params) {
            builder.add(key, value)
        }
    }
}