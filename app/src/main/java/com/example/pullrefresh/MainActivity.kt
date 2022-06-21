package com.example.pullrefresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.Recycleriew)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val item =fetchData()

        val adaptor = RVAdaptor(item)
        recyclerView.adapter = adaptor
    }

    fun fetchData() : ArrayList<String>{
        val list = ArrayList<String>()
        for(i in 0 until  1){
            list.add("item $i")
        }
        return list
    }
} 