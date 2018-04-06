package com.txl.wanandroid.my_wanandroid.activity

import android.widget.EditText
import android.widget.Toast
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import com.txl.wanandroid.my_wanandroid.utils.PreferenceUtils
import kotlinx.android.synthetic.main.activity_login.*

/**
 *
 * 项目名称: 药到家
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/3/29 0029 21:26
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class LoginActivity : BaseActivity() {

    /**
     * 相当于懒加载  第一次调用才会初始化  只试用与val类型
     */
    val username: EditText by lazy { login_username.editText!! }
    val pwd: EditText by lazy { login_pwd.editText!! }
    var name: String by PreferenceUtils<String>("isLogin", "测试")
    override fun initView() {

        var editText = login_username.editText
        /**
         * kotlin的lab表达式
         */
        regist.setOnClickListener {
            //tijiao
            if (username.text.isNullOrBlank()) {
                login_username.error = getString(R.string.login_pwd_empty).toString()
                login_username.isErrorEnabled = true
            }
            Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
            name = "田晓龙"
        }

    }


    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun loadData() {

    }

    fun get(a: Int, b: Int, pardsa: (a: Int, b: Int) -> Boolean): Int {
        return if (pardsa(a, b)) {
            a
        } else {
            b
        }
    }


    /**
     * 高阶函数
     */
    fun <T, R> List<T>.asd(abb: (T) -> R): List<R> {
        var list = ArrayList<R>()
        for (item in this) {
            var abb1 = abb(item)
            list.add(abb1)
        }
        return list
    }


}
