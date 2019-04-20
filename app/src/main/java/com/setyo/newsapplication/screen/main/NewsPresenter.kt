package com.setyo.newsapplication.screen.main

import android.util.Log
import com.google.gson.Gson
import com.setyo.newsapplication.model.ArticlesItem
import com.setyo.newsapplication.model.NewsResponse
import com.setyo.newsapplication.network.ApiService
import com.setyo.newsapplication.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsPresenter(val mainView: MainView) : NewsPresenterImp{

    override fun getDataFromApi() {

        GlobalScope.launch(Dispatchers.Main){

            val data = Gson().fromJson(
                ApiService().doRequest(Network.getHeadlinefromBBC()).await(),
                NewsResponse::class.java
            )

            mainView.onSuccess(data.articles as List<ArticlesItem>)
            Log.d("cek",data.articles.toString())

        }



    }


}