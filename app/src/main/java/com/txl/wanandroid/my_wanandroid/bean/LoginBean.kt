package com.txl.wanandroid.my_wanandroid.bean

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/15 0015 23:57
 * 修改人:
 * 修改内容:
 * 修改时间:
 */



data class LoginBean(
		val data: Data = Data(),
		val errorCode: Int = 0, //0
		val errorMsg: String = ""
) {
	data class Data(
			val collectIds: List<Int> = listOf(),
			val email: String = "", //tttx0307@163.com
			val icon: String = "",
			val id: Int = 0, //428
			val password: String = "", //tianxiaolong
			val type: Int = 0, //0
			val username: String = "" //tianxiaolong
	)
}