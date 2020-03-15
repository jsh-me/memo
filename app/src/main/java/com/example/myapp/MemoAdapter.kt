package com.example.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.data.Data
import kotlinx.android.synthetic.main.memo_list.view.*

/*
getItemCount: 보여줄 아이템 개수가 몇개인지 알려줍니다
onCreateViewHolder: 보여줄 아이템 개수만큼 View를 생성합니다
onBindViewHolder: 생성된 View에 보여줄 데이터를 설정(set)해줍니다
ViewHolder: ViewHolder 단위 객체로 View의 데이터를 설정합니다
 */

class MemoAdapter (val memolist: ArrayList<Data>, var click: (Int) -> Unit):
        RecyclerView.Adapter<Holder>() {

    //RecyclerView가 초기화 될 때 onCreateViewHolder가 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.memo_list, parent, false)
        return Holder(inflatedView)
    }

    override fun getItemCount(): Int {
        return memolist.size
    }

        //View가 생성되면 onBindViewHolder가 호출
        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.bind(memolist[position].id, memolist[position].title, memolist[position].content, click)
        }

//    fun adduserData(title:String, content: String){
//        memolist.add(Data(itemCount + 1, title, content))
//    }

    }



class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    //bind 함수는 ViewHolder와 클래스의 각 변수를 연동하는 역할을 한다. 이후에 Override 할 함수에서 사용할 것이다.
    fun bind(id:Int, title: String, content: String, click: (Int) -> Unit){
        itemView.txt_content.text = content
        itemView.txt_title.text = title
        itemView.setOnClickListener { click(id)  }

    }
}