package com.example.myapp.write



interface WriteContract {
//    interface View{ //뿌린 데이터를 보여주고
//        fun addUserData(list: ArrayList<Data>)
//    }

    interface Presenter { //데이터를 보내고
        fun addData(title:String, content:String)
    }
}