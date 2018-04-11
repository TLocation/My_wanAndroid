package com.txl.wanandroid.my_wanandroid.adapter

import android.widget.AdapterView
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseRecyclerAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseViewHolder
import com.txl.wanandroid.my_wanandroid.bean.home.HomeList

/**
 * 项目名称：玩Android
 * 类描述：
 *
 * Created by YC on 2018/4/10 23:44
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
class HomeListAdapter(layouts: Int,
                      dataList: Collection<HomeList.Data.Data>,
                      onItemClickListener: AdapterView.OnItemClickListener) :
        BaseRecyclerAdapter<HomeList.Data.Data>(layouts, dataList, onItemClickListener) {

    override fun conver(baseViewHolder: BaseViewHolder, data: HomeList.Data.Data,
                        position: Int, type: Int) {

        baseViewHolder.setText(R.id.home_item_title, data.title)
        baseViewHolder.setText(R.id.home_item_author, data.author)
        baseViewHolder.setText(R.id.home_item_chapter, data.chapterName)
        baseViewHolder.setText(R.id.home_item_time, data.niceDate)

    }
}