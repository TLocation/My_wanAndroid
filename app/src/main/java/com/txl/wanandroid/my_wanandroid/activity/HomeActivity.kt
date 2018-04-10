package com.txl.wanandroid.my_wanandroid.activity

import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import com.txl.wanandroid.my_wanandroid.base.BaseFragmentBuilder
import com.txl.wanandroid.my_wanandroid.fragment.HomeFragment

class HomeActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
    }

    override fun loadData() {
        BaseFragmentBuilder.getInstance(this)
                .start(HomeFragment::class.java)
                .add(R.id.home_content).commit()

    }
}



