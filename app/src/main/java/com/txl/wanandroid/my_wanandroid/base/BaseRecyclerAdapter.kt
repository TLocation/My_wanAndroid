package com.txl.wanandroid.my_wanandroid.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/10 0010 16:48
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


abstract class BaseRecyclerAdapter<T>(layouts: IntArray, dataList: Collection<T>) : RecyclerView.Adapter<BaseViewHolder>() {
    protected val layouts: IntArray = layouts
    protected var dataList: ArrayList<T> = ArrayList<T>(dataList)

    protected var onItemClickListener: AdapterView.OnItemClickListener? = null
    fun refresh(data: Collection<T>? = null) {
        dataList.clear()
        dataList.addAll(data!!)
        notifyDataSetChanged()
    }

    fun loadMore(data: Collection<T>) {
        dataList.addAll(data)
        notifyDataSetChanged()
    }




    constructor(layout: Int, dataList: Collection<T>) : this(intArrayOf(layout), dataList)


    constructor(layouts: IntArray, dataList: Collection<T>, onItemClickListener: AdapterView.OnItemClickListener) : this(layouts, dataList) {
        this.onItemClickListener = onItemClickListener
    }

    constructor(layouts: Int, dataList: Collection<T>, onItemClickListener: AdapterView.OnItemClickListener) : this(layouts, dataList) {
        this.onItemClickListener = onItemClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        var baseViewHolder: BaseViewHolder
        if (layouts.size === 0) {
            baseViewHolder = BaseViewHolder(LayoutInflater.from(parent!!.context).inflate(layouts[0], parent, false), onItemClickListener)
        } else {
            baseViewHolder = BaseViewHolder(LayoutInflater.from(parent!!.context).inflate(layouts[viewType], parent, false), onItemClickListener)
        }
        return baseViewHolder
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        conver(holder!!, dataList.get(position), position, getItemViewType(position))
    }

    /**
     * @param baseViewHolder 基础ViewHolder
     * @param data 返回的当前需要构造item的data
     * @param position 当前item的索引
     * @param type   当前item的类型 如果有
     *
     */
    abstract fun conver(baseViewHolder: BaseViewHolder, data: T, position: Int, type: Int)
}