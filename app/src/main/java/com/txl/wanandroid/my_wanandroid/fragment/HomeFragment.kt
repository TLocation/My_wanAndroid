package com.txl.wanandroid.my_wanandroid.fragment

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import com.txl.wanandroid.my_wanandroid.R
import com.txl.wanandroid.my_wanandroid.adapter.HomeListAdapter
import com.txl.wanandroid.my_wanandroid.adapter.HomeVpAdapter
import com.txl.wanandroid.my_wanandroid.base.BaseFragment
import com.txl.wanandroid.my_wanandroid.bean.home.HomeBanner
import com.txl.wanandroid.my_wanandroid.bean.home.HomeList
import com.txl.wanandroid.my_wanandroid.net.MyOkhttp
import com.txl.wanandroid.my_wanandroid.net.response.GsonResponse
import com.txl.wanandroid.my_wanandroid.utils.UrlUtils
import com.txl.wanandroid.my_wanandroid.view.DividerUtils
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.home_header_vp.*
import java.util.*
import kotlin.concurrent.timerTask

/**
 * 项目名称：玩Android
 * 类描述：
 *
 * Created by YC on 2018/4/7 21:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
class HomeFragment : BaseFragment(), AdapterView.OnItemClickListener {

    lateinit var homeList: ArrayList<HomeList.Data.Data>

    lateinit var listAdapter: HomeListAdapter

    lateinit var homeBanner: ArrayList<HomeBanner.Data>

    var PAGE: Int = 0

    lateinit var timer: Timer

    lateinit var task: TimerTask

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun init() {

        homeList = ArrayList()

        homeBanner = ArrayList()

        var manager = LinearLayoutManager(activity)

        manager.orientation = LinearLayoutManager.VERTICAL

        fragment_home_rll.layoutManager = manager

        fragment_home_rll.addItemDecoration(DividerUtils(activity, LinearLayout.HORIZONTAL,
                40, activity.getColor(R.color.white)))

        listAdapter = HomeListAdapter(R.layout.home_list_item, homeList, this)
//        var wrapper = RecyclerViewWrapper<HomeList.Data.Data>(listAdapter )
        val view = LayoutInflater.from(activity).inflate(R.layout.home_header_vp, null)
        listAdapter.addHeaderView(view)
        fragment_home_rll.adapter = listAdapter


    }

    fun initVp() {

        home_head_vp.pageMargin = 80

        home_head_vp.offscreenPageLimit = 3

        home_head_vp.currentItem = Int.MAX_VALUE / 2

        var imgs: ArrayList<String>

        imgs = ArrayList()

        for (img in homeBanner) {

            imgs.add(img.imagePath)

        }

        for (tt in imgs) {

            Log.e("图片地址", tt)

        }

        var imgAdapter = HomeVpAdapter(activity, imgs)

        home_head_vp.adapter = imgAdapter

        timer = Timer(true)

        task = object : TimerTask() {
            override fun run() {

                activity.runOnUiThread {

//                    home_head_vp.currentItem = home_head_vp.currentItem + 1

                    Log.e("Timer", System.currentTimeMillis().toString())

                }
            }
        }

        timer.schedule(task, 3000)

    }

    override fun loadData() {

        MyOkhttp.get()
                .url(UrlUtils.GET_HOME_ARTICLE_LIST(PAGE)).enqueue(object : GsonResponse<HomeList>() {
                    override fun onFeail(statCode: Int, errorMsg: String?) {
                        toast(errorMsg!!)
                    }

                    override fun onSuccful(statCode: Int, response: HomeList) {
                        homeList.addAll(response.data.datas)

                        listAdapter.refresh(homeList)
                    }

                })

        MyOkhttp.get()
                .url(UrlUtils.HOME_BANNER).enqueue(object : GsonResponse<HomeBanner>() {
                    override fun onFeail(statCode: Int, errorMsg: String?) {
                        toast(errorMsg.toString())
                    }

                    override fun onSuccful(statCode: Int, response: HomeBanner) {
                        homeBanner.addAll(response.data)

                        initVp()
                    }

                })

    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        toast("跳转...$p2")

    }

    override fun onDestroyView() {
        super.onDestroyView()

        timer.cancel()

    }
}