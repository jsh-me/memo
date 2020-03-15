package com.example.myapp.edit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.data.Data
import com.example.myapp.R
import com.example.myapp.delete.Deletepresenter
import com.example.myapp.main.MainActivity
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity :AppCompatActivity(), EditContract.View {
    var presenter = EditPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        var id:Int = intent.getIntExtra("id",0)

        edit(id)

        edit_btn.setOnClickListener { updatedata(id) }
        delete_btn.setOnClickListener { deletedata(id) }



    }

    fun deletedata(id:Int) {
        var presenter = Deletepresenter()
        presenter.deleteuserdata(id)

        var intent = Intent(this@EditActivity, MainActivity::class.java)
        startActivity(intent)
    }


    fun edit(id: Int){
       presenter.getuserData(id)
    }

    fun updatedata(id:Int){
        presenter.edituserData(id,edit_title.text.toString(), edit_content.text.toString())
        Log.i("update:","${id}, ${edit_title.text}, ${edit_content.text}")

        var intent= Intent(this@EditActivity, MainActivity::class.java)
        startActivity(intent)
    }

    override fun getuserView(list: Data) {
        edit_title.setText(list.title)
        edit_content.setText(list.content)
    }

}