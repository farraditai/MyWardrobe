package com.example.mywardrobe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_tips.*

class TipsActivity : AppCompatActivity() {
    private val list = ArrayList<tips>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        rv_tips.setHasFixedSize(true)
        list.addAll(getListTips())
        showRecyclerList()
    }
    fun getListTips(): ArrayList<tips> {
        val dataName = resources.getStringArray(R.array.data_name3)
        val dataDescription = resources.getStringArray(R.array.data_description3)
        val dataPhoto = resources.getStringArray(R.array.data_photo3)
        val listTips = ArrayList<tips>()
        for (position in dataName.indices) {
            val tips = tips(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listTips.add(tips)
        }
        return listTips
    }

    private fun showRecyclerList() {
        rv_tips.layoutManager = LinearLayoutManager(this)
        val listTipsAdapter = ListTipsAdapter(list)
        rv_tips.adapter = listTipsAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main3, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }
            R.id.action_grid -> {
            }
            R.id.action_cardview -> {
            }
        }
    }
}
