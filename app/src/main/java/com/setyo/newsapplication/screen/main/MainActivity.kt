package com.setyo.newsapplication.screen.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.setyo.newsapplication.R
import com.setyo.newsapplication.model.ArticlesItem
import com.setyo.newsapplication.screen.detail.DetailActivity
import org.jetbrains.anko.find


class MainActivity : AppCompatActivity(),MainView {

    lateinit var presenter : NewsPresenter

    //recyclerview
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter
    private var data: MutableList<ArticlesItem> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        initView()
    }

    private fun initView() {
        //recyclerView
        recyclerView = find(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(this, data, { partItem: ArticlesItem -> partItemClicked(partItem) })
        recyclerView.adapter = adapter

        presenter.getDataFromApi()
    }

    private fun partItemClicked(partItem: ArticlesItem) {

        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("dataParcel",partItem)
        startActivity(intent)

    }

    private fun initPresenter() {
        presenter = NewsPresenter(this)
    }

    override fun onSuccess(data: List<ArticlesItem>) {
        Toast.makeText(this,data.get(0).author.toString(),Toast.LENGTH_LONG).show()

        //set to adapter
        this.data.clear()
        this.data.addAll(data)
        adapter.notifyDataSetChanged()

    }

    override fun onFailure(pesan: String) {

    }
}
