package com.txl.wanandroid.my_wanandroid.net.response

import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import okhttp3.Response

/**
 *
 * 项目名称: 药到家
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/5 0005 20:07
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


abstract class RawResponse : IResponse {
    override fun onSuccful(response: Response) {
        var body: String
        val body1 = response.body()
        body = body1?.string() ?: ""
        body1!!.close()
        MyOkhttp.hanlder.post { onSuccful(response.code(), body) }
    }

    abstract fun onSuccful(statCode: Int, response: String)
}