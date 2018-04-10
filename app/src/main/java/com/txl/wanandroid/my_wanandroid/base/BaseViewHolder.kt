package com.txl.wanandroid.my_wanandroid.base

import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/10 0010 16:51
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class BaseViewHolder(itemView: View, onItemClickListener: AdapterView.OnItemClickListener?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    override fun onClick(p0: View?) {
        onItemClickListener!!.onItemClick(null, p0, adapterPosition, itemId)
    }

    val onItemClickListener = onItemClickListener

    init {
        itemView.setOnClickListener(this)
        if (itemView.background == null) {
            val typevalue = TypedValue()
            val them = itemView.context.theme
            val top = itemView.paddingTop
            val bottom = itemView.paddingBottom
            val right = itemView.paddingRight
            val left = itemView.paddingLeft
            if (them.resolveAttribute(android.R.attr.selectableItemBackground, typevalue, true)) itemView.setBackgroundResource(typevalue.resourceId)
            itemView.setPadding(left, top, right, bottom)
        }
    }

    fun setText(@IdRes id: Int, text: CharSequence? = null, @StringRes stringres: Int = 0) {
        var view = getView(id)
        if (view is TextView) {
            if (text == null) view.setText(stringres) else view.text = text
        }
    }
   fun setImgResouse(id:Int,resid:Int){
       var view = getView(id)
       if(view is ImageView) view.setImageResource(resid)
   }



    fun getView(@IdRes id: Int) = itemView.findViewById<View>(id)
}

