package com.txl.wanandroid.my_wanandroid.activity

import android.os.Bundle
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.adapter.KnowPageAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import com.txl.wanandroid.my_wanandroid.bean.knowledge.KnowledgeBean
import com.txl.wanandroid.my_wanandroid.fragment.know.KnowPageFragment
import com.txl.wanandroid.my_wanandroid.utils.KeyUtils
import kotlinx.android.synthetic.main.activity_knowledge_tab.*

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/17 0017 18:54
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class KnowkedgeTabActivity : BaseActivity() {
    val fragmentList: ArrayList<KnowPageFragment> by lazy { ArrayList<KnowPageFragment>() }
    lateinit var adapter: KnowPageAdapter
    override fun getLayoutId(): Int {
        return R.layout.activity_knowledge_tab
    }

    override fun initView() {
        if (intent == null) return
        var title = intent.getStringExtra(KeyUtils.KNOW_KEY_TITLE)
        var parcelableArrayListExtra = intent.getParcelableArrayListExtra<KnowledgeBean.Data.Children>(KeyUtils.KNOW_KEY_CID)
        parcelableArrayListExtra.forEach { it ->
            var pageFragment = KnowPageFragment()
            var bundle = Bundle()
            bundle.putInt(KeyUtils.KNOW_PAGE_KEY_CID, it.id)
            pageFragment.arguments = bundle
            fragmentList.add(pageFragment)
        }
        knowTitle.text = title
        adapter = KnowPageAdapter(fragmentList, parcelableArrayListExtra, supportFragmentManager)
        knowViewPager.adapter = adapter
        knowTabLayout.setupWithViewPager(knowViewPager)
    }

    override fun loadData() {
    }

}