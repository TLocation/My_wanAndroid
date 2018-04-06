package com.txl.wanandroid.my_wanandroid.utils

import android.content.Context
import android.content.SharedPreferences
import java.lang.RuntimeException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * 项目名称: WanAndroid
 * 类描述:   SharePreference工具类
 * 创建人: 田晓龙
 * 创建时间: 2018/4/6 0006 17:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class PreferenceUtils<T>(val key: String, val default: T?) : ReadWriteProperty<Any?, T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {

        return findValue(key, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putSp(key, value)
    }

    constructor(key: String) : this(key, null)

    companion object {
        lateinit var sp: SharedPreferences

        /**
         * 这个方法在Application 调用初始化
         */
        fun setContext(context: Context) {
            sp = context.getSharedPreferences("wanAndroid", Context.MODE_PRIVATE)
        }
    }


    fun <E> putSp(key: String, value: E) {
        with(sp.edit()) {
            when (value) {
                is String -> putString(key, value)
                is Long -> putLong(key, value)
                is Boolean -> putBoolean(key, value)
                is Float -> putFloat(key, value)
                is Set<*> -> putStringSet(key, value as Set<String>)
                else -> throw  RuntimeException("类型不对")
            }
        }.commit()
    }

    fun <E> findValue(key: String, default: E?): E {
        return with(sp) {
            var result: Any = when (default) {
                is Long -> getLong(key, default)
                is String -> getString(key, default)
                is Float -> getFloat(key, default)
                is Boolean -> getBoolean(key, default)
                is Set<*> -> getStringSet(key, default as Set<String>)
                else -> throw  RuntimeException("类型不对")
            }
            result as E
        }
    }

}