package com.txl.wanandroid.my_wanandroid.bean.home

/**
 * 项目名称：玩Android
 * 类描述：
 *
 * Created by YC on 2018/4/10 17:32
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

data class HomeList(
		val data: Data = Data(),
		val errorCode: Int = 0, //0
		val errorMsg: String = ""
) {
	data class Data(
			val curPage: Int = 0, //1
			val datas: List<Data> = listOf(),
			val offset: Int = 0, //0
			val over: Boolean = false, //false
			val pageCount: Int = 0, //60
			val size: Int = 0, //20
			val total: Int = 0 //1198
	) {
		data class Data(
				val apkLink: String = "",
				val author: String = "", //帥酥
				val chapterId: Int = 0, //260
				val chapterName: String = "", //RxJava & Retrofit & MVP
				val collect: Boolean = false, //false
				val courseId: Int = 0, //13
				val desc: String = "",
				val envelopePic: String = "",
				val fresh: Boolean = false, //true
				val id: Int = 0, //2803
				val link: String = "", //https://blog.csdn.net/s003603u/article/details/56670819
				val niceDate: String = "", //16分钟前
				val origin: String = "",
				val projectLink: String = "",
				val publishTime: Long = 0, //1523351642000
				val superChapterId: Int = 0, //135
				val superChapterName: String = "", //项目必备
				val tags: List<Any> = listOf(),
				val title: String = "", //基于Activity、Fragment的生命周期避免MVP模式内存泄露的问题
				val type: Int = 0, //0
				val visible: Int = 0, //1
				val zan: Int = 0 //0
		)
	}
}