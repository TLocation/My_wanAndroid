package com.txl.wanandroid.my_wanandroid.bean.project

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: YC
 * 创建时间: 2018/4/17 19:18
 * 修改人:
 * 修改内容:
 * 修改时间:
 */



data class ProjectTabBean(
        val data: List<Data> = listOf(),
        val errorCode: Int = 0, //0
        val errorMsg: String = ""
) {
	data class Data(
			val children: List<Any> = listOf(),
			val courseId: Int = 0, //13
			val id: Int = 0, //294
			val name: String = "", //完整项目
			val order: Int = 0, //145000
			val parentChapterId: Int = 0, //293
			val visible: Int = 0 //0
	)
}