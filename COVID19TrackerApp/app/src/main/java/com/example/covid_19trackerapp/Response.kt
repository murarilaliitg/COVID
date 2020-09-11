package com.example.covid_19trackerapp

data class Response (
    val statewise: List<stateWiseItem>
)
data class stateWiseItem (
    val recorved: String?=null,
    val delta: Delta?=null,
    val active: String?=null,
    val state: String?=null,
    val confirmed: String?=null,
    val deaths:String?=null
)
data class Delta (
    val recovered:Int?=null,
    val active:Int?=null,
    val confirmed: Int?=null,
    val deaths: Int?=null
)

