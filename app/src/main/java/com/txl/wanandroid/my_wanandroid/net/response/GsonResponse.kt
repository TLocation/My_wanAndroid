package com.txl.wanandroid.my_wanandroid.net.response

import com.google.gson.Gson
import com.google.gson.internal.`$Gson$Types`
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import okhttp3.Response
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 *
 * 项目名称: 药到家
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/5 0005 20:12
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


abstract class GsonResponse<T> : IResponse {
    val gson: Gson by lazy { Gson() }
     var type: Type
    init {
        var myClass = javaClass.genericSuperclass
        if (myClass is Class<*>) {
            throw  RuntimeException("Missing type parameter.")
        }
        val parameter = myClass as ParameterizedType
        type = `$Gson$Types`.canonicalize(parameter.actualTypeArguments[0])
    }

    override fun onSuccful(response: Response) {
        var body = response.body()
        var str: String
        if (body != null) {
            str = body.string()
            body.close()
        } else {
            body!!.close()
            MyOkhttp.hanlder.post { onFeail(response.code(), "not read response") }
            return
        }

        MyOkhttp.hanlder.post {
            onSuccful(response.code(), gson.fromJson(str, type)) }
    }

    abstract fun onSuccful(statCode: Int, response: T)

}