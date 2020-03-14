package com.example.myapp

import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*

/*
POST : 리소스 생성
GET : 리소스 조회 및 획득
PUT : 리소스 수정
DELETE : 리소스 삭제
 */

interface UserService {
    @GET("/memo")
    fun getData() :Observable<ArrayList<Data>>

    @GET("/memo/{id}")
    fun getUserData(@Path("id") id:Int ):Observable<Data>

    @PUT("/memo/{id}")
    fun editData(@Path("id") id: Int) :Observable<ArrayList<Data>>

    @POST("/memo")
    fun addData(@Body data: Data): Flowable<Data> //해당 data를 넣으면 db로 감


    @DELETE("/memo/{id}")
    fun deleteData(@Path("id") id:Int ) :Flowable<Data>
}