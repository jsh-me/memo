package com.example.myapp.usecase

import com.example.myapp.Network.RetrofitUtil
import com.example.myapp.Network.UserService
import com.example.myapp.data.Data
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PutDataUsecase {
    val userService: UserService =
        RetrofitUtil.retrofitBuilder().create(UserService::class.java)

    fun edituserdata(id: Int, title: String, content: String): Observable<Data> =
        userService.editData(id, Data(id, title, content))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}