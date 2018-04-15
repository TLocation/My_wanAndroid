package com.txl.wanandroid.my_wanandroid.adapter

import android.view.View
import android.widget.AdapterView
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseRecyclerAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseViewHolder
import com.txl.wanandroid.my_wanandroid.bean.nav.NavDataBean

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/12 0012 17:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class NavAdapter(layouts: Int, dataList: Collection<NavDataBean.Data>,
                 onItemClickListener: AdapterView.OnItemClickListener)
    : BaseRecyclerAdapter<NavDataBean.Data>(layouts, dataList, onItemClickListener) {
    val TAG = javaClass.simpleName
    var lView: View? = null
    var lPosition = 0
    override fun conver(baseViewHolder: BaseViewHolder, data: NavDataBean.Data, position: Int, type: Int) {
        if (baseViewHolder.adapterPosition == lPosition) {
            baseViewHolder.getView(R.id.item_text).setBackgroundResource(R.drawable.select_nav_item)
            lView = baseViewHolder.itemView
        } else {
            baseViewHolder.getView(R.id.item_text).setBackgroundColor(0)
        }
        baseViewHolder.setText(R.id.item_text, data.name)
        baseViewHolder.holderClcik = object : BaseViewHolder.onHolderClcik {
            override fun onViewClick(view: View) {
                lView?.findViewById<View>(R.id.item_text)?.setBackgroundColor(0)
                baseViewHolder.getView(R.id.item_text).setBackgroundResource(R.drawable.select_nav_item)
                lView = view
                lPosition = baseViewHolder.adapterPosition
            }

        }
    }

}