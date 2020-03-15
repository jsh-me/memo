package com.example.myapp.usecase

import com.example.myapp.Network.RetrofitUtil
import com.example.myapp.Network.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DeleteDataUsecase {
    val userService: UserService =
        RetrofitUtil.retrofitBuilder().create(UserService::class.java)

    fun deletedata(id: Int) = userService.deleteData(id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}