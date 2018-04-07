package com.txl.wanandroid.my_wanandroid.net

import com.txl.wanandroid.my_wanandroid.net.response.IResponse
import okhttp3.Request

/**
 *
 * 项目名称: 药到家
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/4 0004 22:35
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


abstract class QuestBuilder<T> {

    protected lateinit var url: String
    protected var headlers: HashMap<String, String> = HashMap()

    protected var params: HashMap<String, String> = HashMap()

    fun url(url: String): T {
        this.url = url
        return this as T
    }

    fun addHeader(key: String, value: String): T {
        headlers.put(key, value)
        return this as T
    }

    fun headers(headers: HashMap<String, String>): T {
        this.headlers = headlers
        return this as T
    }

    fun addParams(key: String, value: String): T {
        params.put(key, value)
        return this as T
    }

    fun params(params: HashMap<String, String>): T {
        this.params = params
        return this as T
    }

    abstract fun enqueue(iResponse: IResponse)


    fun appendHeaders(builder:Request.Builder,headers: HashMap<String, String>){
        for((key,value) in headers){
            builder.addHeader(key,value)
        }
    }

}