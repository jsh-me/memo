package com.example.myapp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.Data
import com.example.myapp.MemoAdapter
import com.example.myapp.R
import com.example.myapp.edit.EditActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View { //여기서는 메모 불러오는 것만 할것임

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    override fun getAllView(list : ArrayList<Data>) {
        //어뎁터 연결
        recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MemoAdapter(list, click())

        }
    }

   private fun click() = { id: Int ->
       var intent = Intent(this@MainActivity, EditActivity::class.java)
       intent.putExtra("id",id)
       Log.i("id:","${id}")
       startActivity(intent)
   }


    fun initView(){
        var presenter = MainPresenter(this)
        presenter.getData()
    }
}
