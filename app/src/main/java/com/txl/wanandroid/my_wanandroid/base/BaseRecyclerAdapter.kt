package com.txl.wanandroid.my_wanandroid.base

import android.database.DataSetObservable
import android.database.DataSetObserver
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListAdapter

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


abstract class BaseRecyclerAdapter<T>(layouts: IntArray, dataList: Collection<T>) : RecyclerView.Adapter<BaseViewHolder>(), ListAdapter {
    protected val layouts: IntArray = layouts
    protected var dataList: ArrayList<T> = ArrayList<T>(dataList)

    protected var onItemClickListener: AdapterView.OnItemClickListener? = null
    private var observable: DataSetObservable = DataSetObservable()
    override fun registerDataSetObserver(p0: DataSetObserver?) {
        observable.registerObserver(p0)
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {
        observable.unregisterObserver(p0)
    }

    override fun getViewTypeCount(): Int {
        return 0
    }

    override fun getItem(p0: Int): Any {
        return 1;
    }

    override fun isEmpty(): Boolean {
        return false
    }

    override fun isEnabled(p0: Int): Boolean {
        return false
    }

    override fun getView(p0: Int, p1: View?, parent: ViewGroup?): View {
        return LayoutInflater.from(parent!!.context).inflate(layouts[0], parent, false)
    }

    override fun areAllItemsEnabled(): Boolean {
        return false;
    }

    override fun getCount(): Int {
        return dataList.size
    }

    fun refresh(data: Collection<T>? = null) {
        dataList.clear()
        dataList.addAll(data!!)
        notifyDataSetChanged()
        notifyListDataSetChanged()
    }

    fun loadMore(data: Collection<T>) {
        dataList.addAll(data)
        notifyDataSetChanged()
        notifyListDataSetChanged()
    }


    fun notifyListDataSetChanged() = observable.notifyChanged()


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