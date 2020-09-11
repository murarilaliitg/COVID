package com.example.covid_19trackerapp

import okhttp3.Request
import okhttp3.OkHttpClient
object Client {
    private val OkHttpClient = OkHttpClient()
    private val request=Request.Builder().url("https://api.covid19india.org/data.json").build()
    val api=OkHttpClient.newCall(request)

}