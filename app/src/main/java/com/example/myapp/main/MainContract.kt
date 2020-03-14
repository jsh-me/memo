package com.example.myapp.main

import com.example.myapp.Data

interface MainContract {

    interface View {
        fun getAllView(list : ArrayList<Data>)
    }

    interface Presenter {
        var view : View
        fun getData()
    }
}