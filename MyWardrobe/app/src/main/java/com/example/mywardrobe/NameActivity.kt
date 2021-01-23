package com.example.mywardrobe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText

const val EXTRA_MESAGGE = "com.example.mywardrobe.MESSAGE"

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
    }
    fun sendMessage (view: View){
        val editText = findViewById<EditText>(R.id.editText1)
        val message = editText.text.toString()
        val intent0 = Intent(this, HomeActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message) }
        startActivity(intent0)
    }
}