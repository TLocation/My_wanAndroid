package com.txl.wanandroid.my_wanandroid.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.txl.wanandroid.my_wanandroid.R

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/12 0012 19:04
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class FlowLayout(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    val TAG = javaClass.simpleName

    companion object {
        private const val SPACING_AUTO = -65536
        private const val SPACING_ALIGN = -655537
        private const val SPACING_UNDEFINED = -65538
        private const val DEFAULT_FLOW = true
        private const val DEFAULT_CHILD_SPACING = 0
        private const val DEFAULT_CHILD_SPACING_FOR_LAST_ROW = SPACING_UNDEFINED
        private const val DEFAULT_ROW_SPACING = 0
        private const val DEFAULT_RTL = false
        private const val DEFAULT_MAX_ROWS = Integer.MAX_VALUE
    }

    private var mFlow = DEFAULT_FLOW
    private var mChildSpacing = DEFAULT_CHILD_SPACING
    private var mChildSpacingForLastRow = DEFAULT_CHILD_SPACING_FOR_LAST_ROW
    private var mRowSpacing: Float = DEFAULT_ROW_SPACING.toFloat()
    private var mAdjustedRowSpacing: Float = DEFAULT_ROW_SPACING.toFloat()
    private var mMaxRows = DEFAULT_MAX_ROWS
    private var mRtl = DEFAULT_RTL
    private val mHorizontalSpacingForRow: ArrayList<Float> by lazy { ArrayList<Float>() }
    private val mHeightForRow: ArrayList<Int> by lazy { ArrayList<Int>() }
    private val mChildNumForRow: ArrayList<Int> by lazy { ArrayList<Int>() }


    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        var x = if (mRtl) (width - paddingRight) else paddingLeft
        var y = paddingTop
        var childIdx = 0
        for (index in mChildNumForRow.indices) {
            var childNum = mChildNumForRow[index]
            val rowHeight = mHeightForRow[index]
            var spacing = mHorizontalSpacingForRow[index]
            /**
             * TODO 测试
             */
            var i = 0
            while (i<childNum&&childIdx<childCount){
                val child = getChildAt(childIdx++)
                if (child.visibility == View.GONE) continue else i++
                var params = child.layoutParams
                var marginLeft = 0
                var marginRight = 0
                var marginTop = 0
                if (params is MarginLayoutParams) {
                    marginLeft = params.leftMargin
                    marginTop = params.topMargin
                    marginRight = params.rightMargin
                }
                var childWidth = child.measuredWidth
                var childHeight = child.measuredHeight
                if (mRtl) {
                    child.layout(x - marginRight - childWidth, y + marginTop, x - marginRight, y + marginTop + childHeight)
                    x -= childWidth + spacing.toInt() + marginLeft + marginRight

                } else {
                    child.layout(x + marginLeft, y + marginTop, x + marginLeft + childWidth, y + marginTop + childHeight)
                    x += childWidth + spacing.toInt() + marginLeft + marginRight
                }

            }

            x = if (mRtl) width - paddingRight else paddingLeft
            y += rowHeight + mAdjustedRowSpacing.toInt();
        }
    }

    init {
        val typeArray = context!!.theme.obtainStyledAttributes(attrs, R.styleable.flowLayout, 0, 0)
        mFlow = typeArray.getBoolean(R.styleable.flowLayout_flow, DEFAULT_FLOW)
        mChildSpacing = typeArray.getDimensionPixelSize(R.styleable.flowLayout_childSpacing, DEFAULT_CHILD_SPACING)
        mChildSpacingForLastRow = typeArray.getDimensionPixelSize(R.styleable.flowLayout_childSpacingForLastRow, DEFAULT_CHILD_SPACING_FOR_LAST_ROW)
        mRowSpacing = typeArray.getDimension(R.styleable.flowLayout_rowSpacing, DEFAULT_ROW_SPACING.toFloat())
        mMaxRows = typeArray.getInt(R.styleable.flowLayout_maxRows, DEFAULT_MAX_ROWS)
        mRtl = typeArray.getBoolean(R.styleable.flowLayout_rtl, DEFAULT_RTL)
        typeArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var widthSize = MeasureSpec.getSize(widthMeasureSpec)
        var widthModle = MeasureSpec.getMode(widthMeasureSpec)
        var heightSize = MeasureSpec.getSize(heightMeasureSpec)
        var heightModle = MeasureSpec.getMode(heightMeasureSpec)
        when(heightModle){
            MeasureSpec.EXACTLY -> Log.e("test","exactly")
            MeasureSpec.AT_MOST -> Log.e("test","atmost    $heightSize")
            MeasureSpec.UNSPECIFIED -> Log.e("test","UNSPECIFIED")
        }
        Log.e(TAG, "clear")
        mHorizontalSpacingForRow.clear()
        mChildNumForRow.clear()
        mHeightForRow.clear()
        var measuredHeight = 0
        var measuredWidth = 0
        var rowWidth = 0
        var maxChildRowHeightInRow = 0
        var childNumInRow = 0
        var rowSize = widthSize - paddingLeft - paddingRight
        var allowFlow = widthModle != MeasureSpec.UNSPECIFIED && mFlow
        var childSpacing = if (mChildSpacing == SPACING_AUTO && widthModle == MeasureSpec.UNSPECIFIED)
                           0 else mChildSpacing

        var tmpSpacing = if (childSpacing == SPACING_AUTO) 0 else childSpacing
        for (i in 0 until childCount) {
            var childView = getChildAt(i)
            if (childView.visibility == View.GONE) continue
            var layoutParams = childView.layoutParams
            var horizontalMargin = 0
            var verticalMargin = 0
            if (layoutParams is MarginLayoutParams) {
                measureChildWithMargins(childView, widthMeasureSpec, 0, heightMeasureSpec, measuredHeight)
                horizontalMargin = layoutParams.leftMargin + layoutParams.rightMargin
                verticalMargin = layoutParams.topMargin + layoutParams.bottomMargin
            } else {
                measureChild(childView, widthMeasureSpec, heightMeasureSpec)
            }
            var childWidth = childView.measuredWidth + horizontalMargin
            var childHeight = childView.measuredHeight + verticalMargin
            if (allowFlow && (rowWidth + childWidth) > rowSize) {
                Log.e(TAG, "next---add")
                mHorizontalSpacingForRow.add(getSpacingForRow(childSpacing, rowSize, rowWidth, childNumInRow))
                mChildNumForRow.add(childNumInRow)
                mHeightForRow.add(maxChildRowHeightInRow)
                if (mHorizontalSpacingForRow.size <= mMaxRows) {
                    measuredHeight += maxChildRowHeightInRow
                }
                measuredWidth = Math.max(measuredWidth, rowWidth)
                /**
                 * 下一行赋值
                 */
                childNumInRow = 1
                rowWidth = childWidth + tmpSpacing
                maxChildRowHeightInRow = childHeight
            } else {
                childNumInRow++
                rowWidth += childWidth + tmpSpacing
                maxChildRowHeightInRow = Math.max(maxChildRowHeightInRow, childHeight)
            }
        }
        if (mChildSpacingForLastRow == SPACING_ALIGN) {
            if (mHorizontalSpacingForRow.size >= 1) {
                mHorizontalSpacingForRow.add(mHorizontalSpacingForRow[mHorizontalSpacingForRow.size - 1])
                Log.e(TAG, "最后一行 spacing---add")
            } else {
                mHorizontalSpacingForRow.add(getSpacingForRow(childSpacing, rowSize, rowWidth, childNumInRow))
                Log.e(TAG, "最后一行---add")
            }
        } else if (mChildSpacingForLastRow != SPACING_UNDEFINED) {
            mHorizontalSpacingForRow.add(getSpacingForRow(mChildSpacingForLastRow, rowSize, rowWidth, childNumInRow))
            Log.e(TAG, "xml赋值---add")
        } else {
            mHorizontalSpacingForRow.add(getSpacingForRow(childSpacing, rowSize, rowWidth, childNumInRow))
            Log.e(TAG, "没有最后一行---add")
        }
        mChildNumForRow.add(childNumInRow)
        mHeightForRow.add(maxChildRowHeightInRow)
        if (mHorizontalSpacingForRow.size <= mMaxRows) {
            measuredHeight += maxChildRowHeightInRow
        }

        measuredWidth = Math.max(measuredWidth, rowWidth)
        if (childSpacing == SPACING_AUTO) {
            measuredWidth = widthSize
        } else if (widthModle == MeasureSpec.UNSPECIFIED) {
            measuredWidth = measuredWidth + paddingLeft + paddingRight
        } else {
            measuredWidth = Math.min(measuredWidth + paddingLeft + paddingRight, widthSize)
        }
        measuredHeight += paddingTop + paddingBottom
        var rowNum = Math.min(mHorizontalSpacingForRow.size, mMaxRows)
        var rowSpacing: Float = if (mRowSpacing == SPACING_AUTO.toFloat() && heightModle == MeasureSpec.UNSPECIFIED) 0f else mRowSpacing
        if (rowSpacing == SPACING_AUTO.toFloat()) {
            if (rowNum > 1) {
                mAdjustedRowSpacing = ((heightSize - measuredHeight) / (rowNum - 1)).toFloat()

            } else {
                mAdjustedRowSpacing = 0f
            }
            measuredHeight = heightSize
        } else {
            mAdjustedRowSpacing = rowSpacing
            if (rowNum > 1) {
                measuredHeight = if (heightModle == MeasureSpec.UNSPECIFIED)
                    (measuredHeight + (mAdjustedRowSpacing * (rowNum - 1)).toInt())
                else
                    (Math.min((measuredHeight + mAdjustedRowSpacing * (rowNum - 1)).toInt(), heightSize))
            }
        }
        Log.e("lkj", "mHorizontalSpacingForRow===>${mHorizontalSpacingForRow.size}mChildNumForRow===>${mChildNumForRow.size}")

        measuredWidth = if (widthModle == MeasureSpec.EXACTLY) widthSize else measuredWidth
        measuredHeight = if (heightModle == MeasureSpec.EXACTLY) heightSize else measuredHeight
        Log.e("test","height===》$measuredHeight  width===>$measuredWidth")
        setMeasuredDimension(measuredWidth, measuredHeight)


    }

    fun getSpacingForRow(spacingAttr: Int, rowSize: Int, usedSize: Int, childNum: Int): Float {
        var spacing: Float
        if (spacingAttr == SPACING_AUTO) {
            if (childNum > 1) {
                spacing = (rowSize - usedSize) / (childNum - 1).toFloat()
            } else {
                spacing = 0f
            }
        } else {
            spacing = spacingAttr.toFloat()
        }
        return spacing
    }

    /**
     * 这个才有pading
     */
    override fun generateLayoutParams(p: LayoutParams?): LayoutParams {
        return MarginLayoutParams(p)
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }


}