package com.txl.wanandroid.my_wanandroid.bean.nav

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/12 0012 17:00
 * 修改人:
 * 修改内容:
 * 修改时间:
 */



data class NavDataBean(
		val data: List<Data> = listOf(),
		val errorCode: Int = 0, //0
		val errorMsg: String = ""
) {
	data class Data(
			val articles: List<Article> = listOf(),
			val cid: Int = 0, //272
			val name: String = "" //常用网站
	) {
		data class Article(
				val apkLink: String = "",
				val author: String = "", //小编
				val chapterId: Int = 0, //272
				val chapterName: String = "", //常用网站
				val collect: Boolean = false, //false
				val courseId: Int = 0, //13
				val desc: String = "",
				val envelopePic: String = "",
				val fresh: Boolean = false, //false
				val id: Int = 0, //1848
				val link: String = "", //https://developers.google.cn/
				val niceDate: String = "", //2018-01-07
				val origin: String = "",
				val projectLink: String = "",
				val publishTime: Long = 0, //1515322795000
				val superChapterId: Int = 0, //0
				val superChapterName: String = "",
				val tags: List<Any> = listOf(),
				val title: String = "", //Google开发者
				val type: Int = 0, //0
				val visible: Int = 0, //0
				val zan: Int = 0 //0
		)
	}
}