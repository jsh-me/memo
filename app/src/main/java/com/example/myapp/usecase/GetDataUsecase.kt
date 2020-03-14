package com.example.myapp.Usecase

import android.annotation.SuppressLint
import android.util.Log
import com.example.myapp.RetrofitUtil
import com.example.myapp.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GetData {
    val userService: UserService =
        RetrofitUtil.retrofitBuilder().create(UserService::class.java)

    fun refreshData() {

        userService.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->


            }, { throwable ->
                Log.e("Refresh error", "${throwable.message}")
            })
    }
}