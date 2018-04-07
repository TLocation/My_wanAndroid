package com.txl.wanandroid.my_wanandroid.net

import android.util.Log
import com.txl.wanandroid.my_wanandroid.net.response.IResponse
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

/**
 *
 * 项目名称: 药到家
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/4 0004 22:49
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class MyCallBack(iResponse: IResponse) : Callback {
    private var iResponse: IResponse

    init {
        this.iResponse = iResponse
    }

    override fun onFailure(call: Call?, e: IOException?) {
        Log.e("LoginActivity", "error==>${e!!.message}+----${e.toString()}")
        MyOkhttp.hanlder.post { iResponse.onFeail(0, e.message) }
    }

    override fun onResponse(call: Call?, response: Response?) {
        if (response!!.isSuccessful) {
            iResponse.onSuccful(response)
        } else {
            MyOkhttp.hanlder.post { iResponse.onFeail(response.code(), response.message()) }
        }
    }
}