package com.txl.wanandroid.my_wanandroid.utils

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.txl.wanandroid.my_wanandroid.base.BaseViewHolder

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/11 0011 1:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


abstract class RecyclerViewWrapper : RecyclerView.Adapter<BaseViewHolder>() {
    val BASE_ITEM_TYPE_HEADER = 100000
    val BASE_ITEM_TYPE_FOOTER = 200000
    //存储头布局
    val mHeaderViews: SparseArrayCompat<View> by lazy { SparseArrayCompat<View>() }
    //存储尾布局
    val mFooterViews: SparseArrayCompat<View> by lazy { SparseArrayCompat<View>() }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        Log.e("test", "onCreateViewHolder")
        if (mHeaderViews.get(viewType) != null) {
            return BaseViewHolder(mHeaderViews.get(viewType),getHeadersCount())
        }
        if (mFooterViews.get(viewType) != null) {
            return BaseViewHolder(mFooterViews.get(viewType),getHeadersCount())
        }
//        mHeaderViews.get(viewType)?.let { return BaseViewHolder(mHeaderViews.get(viewType)) }
//        mFooterViews.get(viewType)?.let { return BaseViewHolder(mFooterViews.get(viewType)) }
        Log.e("test", "执行默认")
//        return adapter.onCreateViewHolder(parent, viewType)
        return onCreateGeneralViewHolder(parent, viewType)
    }

    abstract fun onCreateGeneralViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder
    override fun getItemCount(): Int {
        return getHeadersCount() + getFootersCount() + getGeneralCount()
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        if (isHeaderViewpos(position)) return
        if (isFooterViewpos(position)) return
//        adapter.onBindViewHolder(holder, position)
        onBindGeneralViewHolder(holder, position - getHeadersCount())
    }

    abstract fun onBindGeneralViewHolder(holder: BaseViewHolder?, position: Int)
    abstract fun getGeneralCount(): Int
    fun getGeneralViewType(position: Int): Int = super.getItemViewType(position)
    override fun getItemViewType(position: Int): Int {
        if (isHeaderViewpos(position)) return mHeaderViews.keyAt(position)
        if (isFooterViewpos(position)) return mFooterViews.keyAt(position - getHeadersCount() - getGeneralCount())
//        return adapter.getItemViewType(position - getHeadersCount())
        return getGeneralViewType(position - getHeadersCount())
    }


    /**
     * 头布局
     */
    fun addHeaderView(view: View) = mHeaderViews.put(mHeaderViews.size() + BASE_ITEM_TYPE_HEADER, view)

    /**
     * 尾布局
     */
    fun addFooterView(view: View) = mFooterViews.put(mFooterViews.size() + BASE_ITEM_TYPE_FOOTER, view)

    protected fun isHeaderViewpos(position: Int) = position < getHeadersCount()
    protected fun isFooterViewpos(position: Int) = position >= (getHeadersCount() + getGeneralCount())
    protected fun getHeadersCount() = mHeaderViews.size()
    protected fun getFootersCount() = mFooterViews.size()


}