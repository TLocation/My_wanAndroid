package com.txl.wanandroid.my_wanandroid.activity

import android.widget.EditText
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
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
    override fun initView() {

        var editText = login_username.editText
        /**
         * kotlin的lab表达式
         */


    }


    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun loadData() {
        val context = baseContext

    }


}
