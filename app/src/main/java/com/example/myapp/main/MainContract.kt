package com.example.myapp.main

import com.example.myapp.data.Data

interface MainContract {

    interface View {
        fun getAllView(list : ArrayList<Data>)
    }

    interface Presenter {
        var view : View
        fun getData()
    }
}