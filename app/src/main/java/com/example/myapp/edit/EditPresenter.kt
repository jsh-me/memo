package com.example.myapp.edit

import android.annotation.SuppressLint
import android.util.Log
import com.example.myapp.usecase.GetUserDataUsecase
import com.example.myapp.usecase.PutDataUsecase

class EditPresenter(override var view: EditContract.View) : EditContract.Presenter {
    var getuserdatausecase = GetUserDataUsecase()
    var putdatausecase = PutDataUsecase()

    override fun getuserData(id:Int) {
        getuserdatausecase.userdata(id)
            .subscribe({
                view.getuserView(it)
            })

    }

    @SuppressLint("CheckResult")
    override fun edituserData(id: Int, title:String, content:String) {
        putdatausecase.edituserdata(id,title,content)
            .subscribe({
                it.content = content
                it.title = title
                Log.i("fun:","${it} and ${it.id}, ${it.content} , ${it.title}")

            },{
                Log.i("edit error:","${it.message}")
            })
    }
}