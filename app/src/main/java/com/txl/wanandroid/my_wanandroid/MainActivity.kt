package com.txl.wanandroid.my_wanandroid

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gyf.barlibrary.ImmersionBar

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var imbar = ImmersionBar.with(this)
        imbar.init()
        //consumer




    }
}
