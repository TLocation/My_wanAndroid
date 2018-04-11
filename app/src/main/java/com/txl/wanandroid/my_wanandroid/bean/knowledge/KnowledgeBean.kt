package com.txl.wanandroid.my_wanandroid.bean.knowledge

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: YC
 * 创建时间: 2018/4/11 2:46
 * 修改人:
 * 修改内容:
 * 修改时间:
 */



data class KnowledgeBean(
		val data: List<Data> = listOf(),
		val errorCode: Int = 0, //0
		val errorMsg: String = ""
) {
	data class Data(
			val children: List<Children> = listOf(),
			val courseId: Int = 0, //13
			val id: Int = 0, //150
			val name: String = "", //开发环境
			val order: Int = 0, //1
			val parentChapterId: Int = 0, //0
			val visible: Int = 0 //1
	) {
		data class Children(
				val children: List<Any> = listOf(),
				val courseId: Int = 0, //13
				val id: Int = 0, //60
				val name: String = "", //Android Studio相关
				val order: Int = 0, //1000
				val parentChapterId: Int = 0, //150
				val visible: Int = 0 //1
		)
	}
}