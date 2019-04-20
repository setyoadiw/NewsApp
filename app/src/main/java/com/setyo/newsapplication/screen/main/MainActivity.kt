package com.setyo.newsapplication.screen.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.setyo.newsapplication.R
import com.setyo.newsapplication.model.ArticlesItem

class MainActivity : AppCompatActivity(),MainView {

    lateinit var presenter : NewsPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        initView()
    }

    private fun initView() {
        presenter.getDataFromApi()
    }

    private fun initPresenter() {
        presenter = NewsPresenter(this)
    }

    override fun onSuccess(data: List<ArticlesItem>) {
        Toast.makeText(this,data.get(0).author.toString(),Toast.LENGTH_LONG).show()

    }

    override fun onFailure(pesan: String) {

    }
}
