package com.example.mywardrobe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_recommend.view.*

class ListTipsAdapter (private val listTips: ArrayList<tips>): RecyclerView.Adapter<ListTipsAdapter.ListView2Holder>(){
    class ListView2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tips: tips) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(tips.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name.text = tips.name
                tv_item_description.text = tips.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListView2Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_tips, parent, false)
        return ListView2Holder(view)
    }

    override fun getItemCount(): Int = listTips.size

    override fun onBindViewHolder(holder: ListView2Holder, position: Int) {
        holder.bind(listTips[position])
    }
}