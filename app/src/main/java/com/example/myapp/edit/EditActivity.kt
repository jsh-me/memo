package com.example.myapp.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.Data
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity :AppCompatActivity(), EditContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        var id:Int = intent.getIntExtra("id",0)

        edit(id)
    }

    fun edit(id: Int){
        var presenter = EditPresenter(this)
       presenter.getuserData(id)
    }

    override fun getuserView(list: Data) {
        edit_title.setText(list.title)
        edit_content.setText(list.content)
    }
}