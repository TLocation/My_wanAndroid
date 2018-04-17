package com.txl.wanandroid.my_wanandroid.bean.knowledge

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/17 0017 19:52
 * 修改人:
 * 修改内容:
 * 修改时间:
 */



data class KnowPageBean(
		val data: Data = Data(),
		val errorCode: Int = 0, //0
		val errorMsg: String = ""
) {
	data class Data(
			val curPage: Int = 0, //1
			val datas: List<Data> = listOf(),
			val offset: Int = 0, //0
			val over: Boolean = false, //true
			val pageCount: Int = 0, //1
			val size: Int = 0, //20
			val total: Int = 0 //5
	) {
		data class Data(
				val apkLink: String = "",
				val author: String = "", //奇卓社
				val chapterId: Int = 0, //269
				val chapterName: String = "", //官方发布
				val collect: Boolean = false, //false
				val courseId: Int = 0, //13
				val desc: String = "",
				val envelopePic: String = "",
				val fresh: Boolean = false, //false
				val id: Int = 0, //2811
				val link: String = "", //http://mp.weixin.qq.com/s/4k3DBlxlSO2xNNKqjqUdaQ
				val niceDate: String = "", //2018-04-12
				val origin: String = "",
				val projectLink: String = "",
				val publishTime: Long = 0, //1523533421000
				val superChapterId: Int = 0, //60
				val superChapterName: String = "", //开发环境
				val tags: List<Any> = listOf(),
				val title: String = "", //突破Android P(Preview 1)对调用隐藏API限制的方法
				val type: Int = 0, //0
				val visible: Int = 0, //1
				val zan: Int = 0 //0
		)
	}
}