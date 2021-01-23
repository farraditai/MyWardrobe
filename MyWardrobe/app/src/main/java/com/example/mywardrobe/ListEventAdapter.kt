package com.example.mywardrobe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_recommend.view.*

class ListEventAdapter (private val listHero: ArrayList<event>): RecyclerView.Adapter<ListEventAdapter.ListViewHolder>(){
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event : event) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(event.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name.text = event.name
                tv_item_description.text = event.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_recommend, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listHero[position])
    }
}