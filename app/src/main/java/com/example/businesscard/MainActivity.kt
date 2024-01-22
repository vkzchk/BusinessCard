package com.example.businesscard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emailButton = findViewById<Button>(R.id.emailBtn)
        emailButton.setOnClickListener {
            val intent  = Intent(this, WriteEmailActivity::class.java)
            startActivity(intent)
        }
    }
}