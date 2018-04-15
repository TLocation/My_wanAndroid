package com.txl.wanandroid.my_wanandroid.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/16 0016 2:40
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


public class TestView extends View{

    public TestView(Context context) {
        this(context,null);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);

    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
    }
}
