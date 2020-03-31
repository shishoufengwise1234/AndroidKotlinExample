package com.kotlin.example.data

/**
 * Created by shishoufeng on 2020-03-31.
 * email:shishoufeng1227@126.com
 *
 *
 * 新闻数据
 *
 */
class NewsData {

    // "reason":"成功的返回",
    // "error_code":0
    /*
    "result":{
		"stat":"1",
		"data":[
			{
				"uniquekey":"8db1e02b01bde2ae4a49dcc090728bf6",
				"title":"大数据深度解读“新基建”，经济增长全靠它？",
				"date":"2020-03-18 10:30:28",
				"category":"军事",
				"author_name":"聚合科技",
				"url":"https:\/\/v.juhe.cn\/toutiao\/s?id=https%3A%2F%2Fmp.weixin.qq.com%2Fs%2FuxekqOSnttOHzZSdzw70aQ",
				"thumbnail_pic_s":"https:\/\/juhe.oss-cn-hangzhou.aliyuncs.com\/api_image\/235\/8db1e02b01bde2ae4a49dcc090728bf6.png",
				"thumbnail_pic_s02":"https:\/\/juhe.oss-cn-hangzhou.aliyuncs.com\/api_image\/235\/8db1e02b01bde2ae4a49dcc090728bf6.png",
				"thumbnail_pic_s03":"https:\/\/juhe.oss-cn-hangzhou.aliyuncs.com\/api_image\/235\/8db1e02b01bde2ae4a49dcc090728bf6.png"
			},

     */
    var reason: String? = ""
    var error_code: Int? = 0
    var result:ResultData? = null



}

class ResultData{

    var stat : String? = "1"
    var data : List<Data>? = null


    override fun toString(): String {
        return "ResultData(stat=$stat, data=$data)"
    }


}

class Data{

    var uniquekey: String? = "8db1e02b01bde2ae4a49dcc090728bf6"
    var title: String? = "大数据深度解读“新基建”，经济增长全靠它？"
    var date : String? = "2020-03-18 10:30:28"
    var category: String? = "军事"
    var author_name: String? = "聚合科技"
    var url: String? = ""
    var thumbnail_pic_s: String? = ""
    var thumbnail_pic_s02: String? = ""
    var thumbnail_pic_s03: String? = ""


    override fun toString(): String {
        return "Data(uniquekey=$uniquekey, title=$title, date=$date, category=$category, author_name=$author_name, url=$url, thumbnail_pic_s=$thumbnail_pic_s, thumbnail_pic_s02=$thumbnail_pic_s02, thumbnail_pic_s03=$thumbnail_pic_s03)"
    }


}