package com.example.myapp.edit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapp.data.Data
import com.example.myapp.R
import com.example.myapp.databinding.ActivityEditBinding
import com.example.myapp.delete.Deletepresenter
import com.example.myapp.main.MainActivity
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity :AppCompatActivity(), EditContract.View {
    lateinit var binding : ActivityEditBinding
    var presenter = EditPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit)
        binding.edit = this@EditActivity
        var id = intent.getIntExtra("id",0)

        edit(id)


    }

    fun DeleteBtn(view: View) {
        var id = intent.getIntExtra("id",0)
        var presenter = Deletepresenter()
        presenter.deleteuserdata(id)
        Log.i("btn:","${id}")

        var intent = Intent(this@EditActivity, MainActivity::class.java)
        startActivity(intent)
    }


    fun edit(id: Int){
       presenter.getuserData(id)
    }


    fun EditBtn(view: View){
        var id = intent.getIntExtra("id",0)
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