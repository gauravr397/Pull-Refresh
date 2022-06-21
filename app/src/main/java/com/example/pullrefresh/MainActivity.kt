package com.example.pullrefresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.Recycleriew)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val item =fetchData()

        val adaptor = RVAdaptor(item)
        recyclerView.adapter = adaptor

        val swipe : SwipeRefreshLayout = findViewById(R.id.swiperefrsh)
        swipe.setOnRefreshListener {
            item.addAll(updateData())
            adaptor.notifyDataSetChanged()
            swipe.isRefreshing=false
        }
    }

    fun fetchData() : ArrayList<String>{
        val list = ArrayList<String>()
        for(i in 0 until  1){
            list.add("Old Text")
        }
        return list
    }

    fun updateData() :ArrayList<String>{
        val item = ArrayList<String>()
            for (j in 1 until 2) {
                item.add("New Text 🔥")
            }
        return item
    }
}