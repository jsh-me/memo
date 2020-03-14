package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() { //여기서는 메모 불러오는 것만 할것임
    var data = ArrayList<Data>()
    var memoAdapter = MemoAdapter(data)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //어뎁터 연결
        recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = memoAdapter
        }

    }
}
