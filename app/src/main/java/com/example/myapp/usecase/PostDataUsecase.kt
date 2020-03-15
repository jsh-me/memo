package com.example.myapp.usecase

import com.example.myapp.data.Data
import com.example.myapp.Network.RetrofitUtil
import com.example.myapp.Network.UserService
import com.example.myapp.data.PostData
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostDataUsecase {
    val userService: UserService =
        RetrofitUtil.retrofitBuilder().create(UserService::class.java)

    fun addnewData(title:String, content:String) : Flowable<Data> =
        userService.addData(PostData(title, content))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}