package com.txl.wanandroid.my_wanandroid.adapter

import android.widget.AdapterView
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseRecyclerAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseViewHolder
import com.txl.wanandroid.my_wanandroid.bean.knowledge.KnowPageBean

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/17 0017 19:56
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class KnowPageContentAdapter(layouts: Int, dataList: Collection<KnowPageBean.Data.Data>, onItemClickListener: AdapterView.OnItemClickListener) : BaseRecyclerAdapter<KnowPageBean.Data.Data>(layouts, dataList, onItemClickListener) {
    override fun conver(holder: BaseViewHolder, data: KnowPageBean.Data.Data, position: Int, type:
    Int) {
        holder.setText(R.id.home_item_title, data.title)
        holder.setText(R.id.home_item_author, data.author)
        holder.setText(R.id.home_item_chapter, data.chapterName)
        holder.setText(R.id.home_item_time, data.niceDate)
    }
}