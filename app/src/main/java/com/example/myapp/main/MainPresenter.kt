package com.example.myapp.main

import android.util.Log
import com.example.myapp.usecase.GetDataUsecase

class MainPresenter(override var view: MainContract.View) : MainContract.Presenter {
    var getDataUsecase = GetDataUsecase()


    override fun getData() {
        getDataUsecase.refreshData()
            .subscribe({
                view.getAllView(it)
            },{
                Log.i("Error","${it.message}")
            })
    }
}