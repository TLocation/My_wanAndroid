package com.txl.wanandroid.my_wanandroid.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.adapter.KnowledgeListAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseFragment
import com.txl.wanandroid.my_wanandroid.bean.knowledge.KnowledgeBean
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import com.txl.wanandroid.my_wanandroid.net.response.GsonResponse
import com.txl.wanandroid.my_wanandroid.utils.UrlUtils
import kotlinx.android.synthetic.main.fragment_knowledge.*

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: YC
 * 创建时间: 2018/4/11 2:37
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class KnowledgeFragment : BaseFragment(), AdapterView.OnItemClickListener {


    lateinit var knowledgeList : ArrayList<KnowledgeBean.Data>

    lateinit var adapter : KnowledgeListAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_knowledge
    }

    override fun init() {

        knowledgeList = ArrayList()

        var manager = LinearLayoutManager(activity)

        manager.orientation = LinearLayoutManager.VERTICAL

        knowledge_rv.layoutManager = manager

        adapter = KnowledgeListAdapter(21, knowledgeList, this)

        knowledge_rv.adapter = adapter
    }

    override fun loadData() {

        MyOkhttp.get().url(UrlUtils.GET_KNOWLEDGE_LIST).enqueue(object : GsonResponse<KnowledgeBean>() {
            override fun onFeail(statCode: Int, errorMsg: String?) {
                toast(errorMsg!!)
            }

            override fun onSuccful(statCode: Int, response: KnowledgeBean) {

                knowledgeList.addAll(response.data)

                adapter.refresh(knowledgeList)

            }

        })

    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }
}