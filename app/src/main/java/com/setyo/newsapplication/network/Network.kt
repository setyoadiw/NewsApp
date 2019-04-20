package com.setyo.newsapplication.network

import com.setyo.newsapplication.BuildConfig

object Network {

    fun getHeadlinefromBBC(): String{
        return BuildConfig.BASE_URL + "top-headlines?sources=bbc-news&apiKey=6edc61704cca438c9f0b447c64e5c9ce"
    }
}