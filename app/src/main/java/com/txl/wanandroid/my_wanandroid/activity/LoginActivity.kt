package com.txl.wanandroid.my_wanandroid.activity

import android.util.Log
import android.widget.EditText
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import com.txl.wanandroid.my_wanandroid.bean.TestOne
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import com.txl.wanandroid.my_wanandroid.net.response.GsonResponse
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
        regist.setOnClickListener {
            //tijiao
            if (username.text.isNullOrBlank())
                login_username.error = getString(R.string.login_pwd_empty).toString()
            login_username.isErrorEnabled = true

        }


    }


    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun loadData() {
        MyOkhttp.get()
                .url("http://www.wanandroid.com/tools/mockapi/428/yc")
                .enqueue(object : GsonResponse<TestOne>() {
                    override fun onFeail(statCode: Int, errorMsg: String?) {
                    }

                    override fun onSuccful(statCode: Int, response: TestOne) {
                        Log.e(TAG,"testone===>${response.ss}")
                    }
                })

    }
}
