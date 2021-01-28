package com.example.mywardrobe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_recommend.view.*

class ListTrendAdapter (private val listTrend: ArrayList<trend>): RecyclerView.Adapter<ListTrendAdapter.ListView3Holder>(){
    class ListView3Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(trend: trend) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(trend.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name.text = trend.name
                tv_item_description.text = trend.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListView3Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_trend, parent, false)
        return ListView3Holder(view)
    }

    override fun getItemCount(): Int = listTrend.size

    override fun onBindViewHolder(holder: ListView3Holder, position: Int) {
        holder.bind(listTrend[position])
    }
}