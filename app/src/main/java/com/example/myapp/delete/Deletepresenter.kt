package com.example.myapp.delete

import android.util.Log
import com.example.myapp.usecase.DeleteDataUsecase

class Deletepresenter : DeleteContract.Presenter {
    var deletedatausecase = DeleteDataUsecase()

    override fun deleteuserdata(id: Int) {
        deletedatausecase.deletedata(id)
            .subscribe({},{
                Log.i("delete error","${it.message}")
            })
    }
}