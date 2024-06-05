package com.example.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class prescriptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prescriptions)

        val homelogoButton: ImageButton = findViewById(R.id.hometoplogo)

        homelogoButton.setOnClickListener {
            startActivity(Intent(this, home::class.java))
        }
    }
}