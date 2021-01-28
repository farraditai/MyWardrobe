package com.example.mywardrobe.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mywardrobe.CustomOnItemClickListener
import com.example.mywardrobe.R
import com.example.mywardrobe.WardrobeAddUpdateActivity
import com.example.mywardrobe.pakaian
import kotlinx.android.synthetic.main.item_pakaian.view.*

class WardrobeAdapter (private val activity: Activity): RecyclerView.Adapter<WardrobeAdapter.WardrobeViewHolder>() {
    var listPakaian = ArrayList<pakaian>()
        set(listNotes) {
            if (listNotes.size > 0) {
                this.listPakaian.clear()
            }
            this.listPakaian.addAll(listNotes)
            notifyDataSetChanged()
        }
    fun addItem(pakaian: pakaian) {
        this.listPakaian.add(pakaian)
        notifyItemInserted(this.listPakaian.size - 1)
    }
    fun updateItem(position: Int, pakaian: pakaian) {
        this.listPakaian[position] = pakaian
        notifyItemChanged(position, pakaian)
    }
    fun removeItem(position: Int) {
        this.listPakaian.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, this.listPakaian.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WardrobeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pakaian, parent, false)
        return WardrobeViewHolder(view)
    }
    override fun onBindViewHolder(holder: WardrobeViewHolder, position: Int) {
        holder.bind(listPakaian[position])
    }
    override fun getItemCount(): Int = this.listPakaian.size
    inner class WardrobeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pakaian: pakaian) {
            with(itemView){
                tv_item_title.text = pakaian.title
                tv_item_date.text = pakaian.jenis
                tv_item_description.text = pakaian.description
                cv_item_note.setOnClickListener(CustomOnItemClickListener(adapterPosition, object : CustomOnItemClickListener.OnItemClickCallback {
                    override fun onItemClicked(view: View, position: Int) {
                        val intent = Intent(activity, WardrobeAddUpdateActivity::class.java)
                        intent.putExtra(WardrobeAddUpdateActivity.EXTRA_POSITION, position)
                        intent.putExtra(WardrobeAddUpdateActivity.EXTRA_NOTE, pakaian)
                        activity.startActivityForResult(intent, WardrobeAddUpdateActivity.REQUEST_UPDATE)
                    }
                }))
            }
        }
    }
}