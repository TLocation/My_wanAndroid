package com.txl.wanandroid.my_wanandroid.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 *RecycleViewDivider
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/16 0016 1:48
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class DividerUtils(var context: Context, orientation: Int) : RecyclerView.ItemDecoration() {
    private var mPaint: Paint? = null
    private var mDivider: Drawable? = null
    private var mDividerHeight = 2
    private var mOrientation: Int = 0
    val attr = intArrayOf(android.R.attr.listDivider)

    /**
     * 默认分割线  颜色为灰色
     *
     */
    init {
        if (orientation != LinearLayoutManager.HORIZONTAL && orientation != LinearLayoutManager.VERTICAL) {
            throw RuntimeException("参数不对")
        }
        mOrientation = orientation
        val typeArry = context.obtainStyledAttributes(attr)
        mDivider = typeArry.getDrawable(0)
        typeArry.recycle()
    }

    constructor(context: Context, orientation: Int, drawable: Int) : this(context, orientation) {
        mDivider = ContextCompat.getDrawable(context, drawable)
        mDividerHeight = mDivider!!.intrinsicHeight
    }

    constructor(context: Context, orientation: Int, height: Int, color: Int) : this(context, orientation) {
        mDividerHeight = height
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint!!.color = color
        mPaint!!.style = Paint.Style.FILL
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect?.set(0, 0, 0, mDividerHeight)
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            drawVertical(c!!, parent!!)
        } else {
            drawHorizontal(c!!, parent!!)
        }
    }

    private fun drawHorizontal(canvas: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.paddingRight
        for (index in 0 until parent.childCount) {
            var view = parent.getChildAt(index)
            var params = view.layoutParams as RecyclerView.LayoutParams
            val top = view.bottom + params.bottomMargin
            val bottom = top + mDividerHeight
            if (mDivider != null) {
                mDivider?.setBounds(left, top, right, bottom)
                mDivider?.draw(canvas)
            }
            if (mPaint != null) {
                canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
            }
        }

    }

    private fun drawVertical(canvas: Canvas, parent: RecyclerView) {
        val top = parent.paddingTop
        val bottom = parent.paddingBottom
        for (i in 0 until parent.childCount) {
            var view = parent.getChildAt(i)
            var params = view.layoutParams as RecyclerView.LayoutParams
            val left = view.right + params.rightMargin
            val right = left + mDividerHeight
            if (mDivider != null) {
                mDivider?.setBounds(left, top, right, bottom)
                mDivider?.draw(canvas)
            }
            if (mPaint != null) {
                canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
            }
        }
    }


}