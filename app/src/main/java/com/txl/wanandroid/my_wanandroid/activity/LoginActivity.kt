package com.txl.wanandroid.my_wanandroid.activity

import android.widget.EditText
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import com.txl.wanandroid.my_wanandroid.net.response.IResponse
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.Response

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


    }


    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun loadData() {
        MyOkhttp.get()
                .url("https://blog.csdn.net/Amethyst128/article/details/73608680")
                .addParams("1", "11")
                .addParams("2", "22")
                .enqueue(object : IResponse {
                    override fun onSuccful(response: Response) {
                    }

                    override fun onFeail(statCode: Int, errorMsg: String?) {
                    }
                });
    }
}
