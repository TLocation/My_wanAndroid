package com.txl.wanandroid.my_wanandroid.bean.home

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: YC
 * 创建时间: 2018/4/16 0:32
 * 修改人:
 * 修改内容:
 * 修改时间:
 */



data class HomeBanner(
		val data: List<Data> = listOf(),
		val errorCode: Int = 0, //0
		val errorMsg: String = ""
) {
	data class Data(
			val desc: String = "", //一起来做个App吧
			val id: Int = 0, //10
			val imagePath: String = "", //http://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png
			val isVisible: Int = 0, //1
			val order: Int = 0, //0
			val title: String = "", //一起来做个App吧
			val type: Int = 0, //0
			val url: String = "" //http://www.wanandroid.com/blog/show/2
	)
}