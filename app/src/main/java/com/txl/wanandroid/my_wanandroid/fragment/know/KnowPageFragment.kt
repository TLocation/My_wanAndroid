package com.txl.wanandroid.my_wanandroid.fragment.know

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.activity.WebActivity
import com.txl.wanandroid.my_wanandroid.adapter.KnowPageContentAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseFragment
import com.txl.wanandroid.my_wanandroid.bean.knowledge.KnowPageBean
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import com.txl.wanandroid.my_wanandroid.net.response.GsonResponse
import com.txl.wanandroid.my_wanandroid.utils.KeyUtils
import com.txl.wanandroid.my_wanandroid.utils.UrlUtils
import com.txl.wanandroid.my_wanandroid.view.DividerUtils
import kotlinx.android.synthetic.main.fragment_knowledge.*

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/17 0017 19:08
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class KnowPageFragment : BaseFragment(), AdapterView.OnItemClickListener {


    val CID = "cid"
    var cid: Int = 0
    lateinit var adapter: KnowPageContentAdapter
    val mList: ArrayList<KnowPageBean.Data.Data> by lazy { ArrayList<KnowPageBean.Data.Data>() }
    override fun getLayoutId(): Int {
        return R.layout.fragment_knowledge
    }

    @SuppressLint("NewApi")
    override fun init() {
        knowledge_rv.layoutManager = LinearLayoutManager(activity)
        knowledge_rv.addItemDecoration(DividerUtils(activity, LinearLayout.HORIZONTAL,
                40, activity.getColor(R.color.white)))
        adapter = KnowPageContentAdapter(R.layout.home_list_item, mList, this)
        knowledge_rv.adapter = adapter
    }

    override fun loadData() {

        MyOkhttp.get()
                .url(UrlUtils.GET_KNOW_PAGE_LIST(0))
                .addParams(CID, cid.toString())
                .enqueue(object : GsonResponse<KnowPageBean>() {
                    override fun onFeail(statCode: Int, errorMsg: String?) {
                    }

                    override fun onSuccful(statCode: Int, response: KnowPageBean) {
                        mList.addAll(response.data.datas)
                        adapter.refresh(mList)
                    }
                })
    }

    override fun getBundle(bundle: Bundle) {
        super.getBundle(bundle)
        cid = bundle.getInt(KeyUtils.KNOW_PAGE_KEY_CID, -1)
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        startActivity(Intent(activity, WebActivity::class.java).putExtra(KeyUtils.WEB_URL,
                mList[p2].link))
    }

}