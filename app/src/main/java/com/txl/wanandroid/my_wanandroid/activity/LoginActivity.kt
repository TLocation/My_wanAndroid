package com.txl.wanandroid.my_wanandroid.activity

import android.util.Log
import android.widget.EditText
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
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


    val username: EditText by lazy { login_username.editText!! }
    val pwd: EditText by lazy { login_pwd.editText!! }

    override fun initView() {

        var editText = login_username.editText
        regist.setOnClickListener {
            //tijiao
            if (username.text.isNullOrBlank())
                login_username.error = getString(R.string.login_pwd_empty).toString()
            login_username.isErrorEnabled = true

        }
        var s= MyOkhttp
        Log.e(TAG, s.toString())
        var e = MyOkhttp
        Log.e(TAG, e.toString())
Log.e(TAG,MyOkhttp.ss)
Log.e(TAG,MyOkhttp.s1)

    }


    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun loadData() {
    }
}
