package com.setyo.newsapplication.screen.main

import com.setyo.newsapplication.model.ArticlesItem

interface MainView {

    fun onSuccess( data : List<ArticlesItem> )

    fun onFailure( pesan : String)
}