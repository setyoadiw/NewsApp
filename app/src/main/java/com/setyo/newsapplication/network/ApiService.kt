package com.setyo.newsapplication.network

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.URL

class ApiService {

    fun doRequest(url: String): Deferred<String> = GlobalScope.async{
        URL(url).readText()
    }
}