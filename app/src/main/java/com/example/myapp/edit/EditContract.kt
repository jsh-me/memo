package com.example.myapp.edit

import com.example.myapp.data.Data

interface EditContract{
    interface View{
        fun getuserView(list : Data)
    }

    interface Presenter{
        var view : View
        fun getuserData(id: Int)
    }
}