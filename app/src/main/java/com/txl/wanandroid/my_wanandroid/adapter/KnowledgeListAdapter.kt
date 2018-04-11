package com.txl.wanandroid.my_wanandroid.adapter

import android.widget.AdapterView
import com.txl.wanandroid.my_wanandroid.base.BaseRecyclerAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseViewHolder
import com.txl.wanandroid.my_wanandroid.bean.knowledge.KnowledgeBean

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: YC
 * 创建时间: 2018/4/11 2:41
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class KnowledgeListAdapter(layouts: Int, dataList: Collection<KnowledgeBean.Data>,
                           onItemClickListener: AdapterView.OnItemClickListener) :
        BaseRecyclerAdapter<KnowledgeBean.Data>(layouts, dataList, onItemClickListener) {
    override fun conver(baseViewHolder: BaseViewHolder,
                        data: KnowledgeBean.Data, position: Int, type: Int) {

    }
}