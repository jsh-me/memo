package com.example.myapp.edit

import com.example.myapp.usecase.GetUserDataUsecase

class EditPresenter(override var view: EditContract.View) : EditContract.Presenter {
    var getuserdatausecase = GetUserDataUsecase()

    override fun getuserData(id:Int) {
        getuserdatausecase.userdata(id)
            .subscribe({
                view.getuserView(it)
            })

    }
}