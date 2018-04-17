package com.txl.wanandroid.my_wanandroid.activity

import android.content.Intent
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioGroup
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.base.BaseActivity
import com.txl.wanandroid.my_wanandroid.base.BaseFragmentBuilder
import com.txl.wanandroid.my_wanandroid.fragment.HomeFragment
import com.txl.wanandroid.my_wanandroid.fragment.KnowledgeFragment
import com.txl.wanandroid.my_wanandroid.fragment.NavFragment
import com.txl.wanandroid.my_wanandroid.fragment.ProjectFragment
import com.txl.wanandroid.my_wanandroid.utils.KeyUtils
import com.txl.wanandroid.my_wanandroid.utils.PreferenceUtils
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), RadioGroup.OnCheckedChangeListener {
    var islogin: Boolean by PreferenceUtils<Boolean>(KeyUtils.IS_LOGIN, false)

    companion object {
        const val LOGIN_RESULT_CODE = 9999999
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
        var seachImageView = homeSeachView.findViewById<ImageView>(R.id.search_mag_icon)
        var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.gravity = Gravity.CENTER_VERTICAL
        seachImageView.layoutParams = params
        seachImageView.setImageResource(R.drawable.seach)

        home_group.setOnCheckedChangeListener(this)
        var item = homeSide.menu.getItem(0)
        if (islogin) item.title = "我的收藏" else item.title = "立即登录"
        homeToobar.setNavigationOnClickListener { home_drawer.openDrawer(Gravity.LEFT) }
    }


    override fun loadData() {

        homeSide.setNavigationItemSelectedListener { item ->
            if (!islogin) startActivityForResult(Intent(this, LoginActivity::class.java), 1)
            true
        }
        homeSide.getHeaderView(0).setOnClickListener { toast("dsadsadsa") }
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
                BaseFragmentBuilder.getInstance(this)
                        .start(KnowledgeFragment::class.java)
                        .add(R.id.home_content).commit()
                homeTitle.text = getString(R.string.home_bottom_knowledge)
            }
            R.id.radio_navigation -> {
                BaseFragmentBuilder.getInstance(this)
                        .start(NavFragment::class.java)
                        .add(R.id.home_content).commit()
                homeTitle.text = getString(R.string.home_bottom_navigation)
            }
            R.id.radio_project -> {
                homeTitle.text = getString(R.string.home_bottom_project)
                BaseFragmentBuilder.getInstance(this)
                        .start(ProjectFragment::class.java)
                        .add(R.id.home_content).commit()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == LOGIN_RESULT_CODE) {
            homeSide.menu.getItem(0).title = "我的收藏"
        }
    }
}



