package com.txl.wanandroid.my_wanandroid.activity

import android.content.Intent
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
        Observable.timer(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { startActivity(Intent(SplashActivity@ this, LoginActivity::class.java)) }
    }

    override fun loadData() {

    }


}
