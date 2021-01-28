package com.example.mywardrobe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_trend.*

class TrendActivity : AppCompatActivity() {
    private val list = ArrayList<trend>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trend)

        rv_trend.setHasFixedSize(true)
        list.addAll(getListTips())
        showRecyclerList()
    }
    fun getListTips(): ArrayList<trend> {
        val dataName = resources.getStringArray(R.array.data_name4)
        val dataDescription = resources.getStringArray(R.array.data_description4)
        val dataPhoto = resources.getStringArray(R.array.data_photo4)
        val listTrend = ArrayList<trend>()
        for (position in dataName.indices) {
            val trend = trend(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listTrend.add(trend)
        }
        return listTrend
    }

    private fun showRecyclerList() {
        rv_trend.layoutManager = LinearLayoutManager(this)
        val listTrendAdapter = ListTrendAdapter(list)
        rv_trend.adapter = listTrendAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main4, menu)
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
