package com.txl.wanandroid.my_wanandroid.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.AdapterView
import android.widget.TextView
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseRecyclerAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseViewHolder
import com.txl.wanandroid.my_wanandroid.bean.knowledge.KnowledgeBean
import com.txl.wanandroid.my_wanandroid.view.FlowLayout
import io.reactivex.Observable

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


class KnowledgeListAdapter(var context: Context, layouts: Int, dataList: Collection<KnowledgeBean
.Data>,
                           onItemClickListener: AdapterView.OnItemClickListener) :
        BaseRecyclerAdapter<KnowledgeBean.Data>(layouts, dataList, onItemClickListener) {
    @SuppressLint("NewApi")
    override fun conver(baseViewHolder: BaseViewHolder,
                        data: KnowledgeBean.Data, position: Int, type: Int) {


        baseViewHolder.setText(R.id.knowledge_item_title, data.name)
        var children = data.children
        Log.e("adapter","size==>${children.size}")
        var flow = baseViewHolder.getView(R.id.knowledge_item_flow) as FlowLayout
        flow.removeAllViews()
        Observable.fromIterable(children)
                .map { it.name }
                .subscribe {
                    val text = TextView(context)
                    text.text = it
                    text.setTextColor(context.getColor(R.color.black))
                    Log.e("adapter","name==>$it")
                    flow.addView(text)
                }


    }
}