package com.example.myapp.write

import com.example.myapp.usecase.PostDataUsecase

class WritePresenter : WriteContract.Presenter {
    var adddatausecase = PostDataUsecase()

    override fun addData( title:String, content:String){
        adddatausecase.addnewData(title, content)
            .subscribe()


    }

}