package com.example.mywardrobe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    var tombol = findViewById<Button>(R.id.button)
    tombol.setOnClickListener(View.OnClickListener {
        var intent = Intent(this, NameActivity::class.java)
        startActivity(intent)
    })
    }
}