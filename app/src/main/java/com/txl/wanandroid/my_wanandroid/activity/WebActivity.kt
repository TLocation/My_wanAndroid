package com.txl.wanandroid.my_wanandroid.activity

import android.widget.LinearLayout
import com.just.agentweb.AgentWeb
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import com.txl.wanandroid.my_wanandroid.utils.KeyUtils
import kotlinx.android.synthetic.main.activity_web.*

/**
 *
 * 项目名称: WanAndroid
 * 类描述:浏览web页面
 * 创建人: 田晓龙
 * 创建时间: 2018/4/14 0014 20:22
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class WebActivity:BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_web
    }

    override fun initView() {
        AgentWeb.with(this)
                .setAgentWebParent(webContent, LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .createAgentWeb()
                .ready()
                .go(intent.getStringExtra(KeyUtils.WEB_URL))
    }

    override fun loadData() {
    }
}