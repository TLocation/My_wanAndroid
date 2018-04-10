package com.txl.wanandroid.my_wanandroid.activity

import android.widget.RadioGroup
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import com.txl.wanandroid.my_wanandroid.base.BaseFragmentBuilder
import com.txl.wanandroid.my_wanandroid.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), RadioGroup.OnCheckedChangeListener {


    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
        home_group.setOnCheckedChangeListener(this)
    }

    override fun loadData() {
        BaseFragmentBuilder.getInstance(this)
                .start(HomeFragment::class.java)
                .add(R.id.home_content).commit()



    }

    /**
     * radioButton的点击事件
     */
    override fun onCheckedChanged(radioGroup: RadioGroup?, checkId: Int) {
        when (checkId) {

            R.id.radio_homePage -> {
                BaseFragmentBuilder.getInstance(this)
                        .start(HomeFragment::class.java)
                        .add(R.id.home_content).commit()
                homeTitle.text = getString(R.string.home_bottom_home)
            }

            R.id.radio_knowledge -> {
                homeTitle.text = getString(R.string.home_bottom_knowledge)
            }
            R.id.radio_navigation -> {
                homeTitle.text = getString(R.string.home_bottom_navigation)
            }
            R.id.radio_project -> {
                homeTitle.text = getString(R.string.home_bottom_project)
            }
        }
    }
}



