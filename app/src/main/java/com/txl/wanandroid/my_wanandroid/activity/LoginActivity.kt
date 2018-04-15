package com.txl.wanandroid.my_wanandroid.activity

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import com.txl.wanandroid.my_wanandroid.bean.LoginBean
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import com.txl.wanandroid.my_wanandroid.net.response.GsonResponse
import com.txl.wanandroid.my_wanandroid.utils.KeyUtils
import com.txl.wanandroid.my_wanandroid.utils.PreferenceUtils
import com.txl.wanandroid.my_wanandroid.utils.UrlUtils
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
//        AndroidBug5497Workaround.assistActivity(this)
        /**
         * 解决状态栏与edittext冲突问题
         */
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        listener()
        login()
    }

    fun listener() {
        username.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.isNullOrEmpty()) {
                    login_username.error = getString(R.string.login_username_empty)
                    login_username.isErrorEnabled = true
                } else {
                    login_username.isErrorEnabled = false
                }
            }
        })
        pwd.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.isNullOrEmpty()) {
                    login_pwd.error = getString(R.string.login_pwd_empty)
                    login_pwd.isErrorEnabled = true
                } else {
                    login_pwd.isErrorEnabled = false
                }
            }
        })
    }

    fun error(message: String) {
        login_pwd.error = message
        login_pwd.isErrorEnabled = true
        login_username.error = message
        login_username.isErrorEnabled = true
    }

    fun login() {
        login.setOnClickListener {
            MyOkhttp.post()
                    .url(UrlUtils.LOGIN_URL)
                    .addParams(KeyUtils.KEY_USERNAME, username.text.toString())
                    .addParams(KeyUtils.KEY_PASSWORD, pwd.text.toString())
                    .enqueue(object : GsonResponse<LoginBean>() {
                        override fun onFeail(statCode: Int, errorMsg: String?) {
                            Log.e(TAG, "error===>$errorMsg")
                        }

                        override fun onSuccful(statCode: Int, response: LoginBean) {

                            if (response.errorCode == -1) {
                                //账号密码不匹配
                                error(response.errorMsg)
                            } else {
                                var islogin by PreferenceUtils<Boolean>(KeyUtils.IS_LOGIN, false)
                                islogin = true
                                setResult(HomeActivity.LOGIN_RESULT_CODE)
                                finish()
                            }
                        }
                    })
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun loadData() {

    }


}
