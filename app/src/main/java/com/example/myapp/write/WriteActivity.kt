package com.example.myapp.write

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.R
import com.example.myapp.main.MainActivity
import kotlinx.android.synthetic.main.activity_edit.*

class WriteActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        edit_btn.text = "등록"
        delete_btn.visibility=View.GONE

        edit_btn.setOnClickListener { newAdd(edit_title.text.toString(), edit_content.text.toString()) }
    }

//    fun WriteBtn(view: View){
//        newAdd(edit_title.text.toString(), edit_content.text.toString())
//
//    }

    fun newAdd(title:String, content:String){
        var presenter = WritePresenter()
        presenter.addData(title, content)

        var intent= Intent(this@WriteActivity, MainActivity::class.java)
        startActivity(intent)
    }

}