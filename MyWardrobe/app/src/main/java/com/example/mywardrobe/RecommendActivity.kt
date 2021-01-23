package com.example.mywardrobe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recommend.*

class RecommendActivity : AppCompatActivity() {
    private val list = ArrayList<event>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        rv_recommend.setHasFixedSize(true)
        list.addAll(getListEvent())
        showRecyclerList()
    }
    fun getListEvent(): ArrayList<event> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listEvent = ArrayList<event>()
        for (position in dataName.indices) {
            val event = event(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listEvent.add(event)
        }
        return listEvent
    }

    private fun showRecyclerList() {
        rv_recommend.layoutManager = LinearLayoutManager(this)
        val listEventAdapter = ListEventAdapter(list)
        rv_recommend.adapter = listEventAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
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