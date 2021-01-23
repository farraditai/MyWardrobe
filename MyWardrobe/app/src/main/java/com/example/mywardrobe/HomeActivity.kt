package com.example.mywardrobe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView3).apply {
            text = message
        }
        var button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener(View.OnClickListener {
        var intent1 = Intent(this, MyWrdActivity::class.java)
            startActivity(intent1)
        })
        var button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener(View.OnClickListener {
            var intent2 = Intent(this, RecommendActivity::class.java)
            startActivity(intent2)
        })
        var button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener(View.OnClickListener {
            var intent3 = Intent(this, TrendActivity::class.java)
            startActivity(intent3)
        })
        var button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener(View.OnClickListener {
            var intent4 = Intent(this, TipsActivity::class.java)
            startActivity(intent4)
        })
    }
}
