package com.example.healthapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homelogoButton: ImageButton = findViewById(R.id.hometoplogo)
        val bookAppointmentButton: ImageButton = findViewById(R.id.bookappointment)
        val myPrescriptionsButton: ImageButton = findViewById(R.id.myprescriptions)
        val healthReportButton: ImageButton = findViewById(R.id.healthreport)
        val requestAssistanceButton: ImageButton = findViewById(R.id.requestassistance)

        homelogoButton.setOnClickListener {
            startActivity(Intent(this, home::class.java))
        }

        bookAppointmentButton.setOnClickListener {
            startActivity(Intent(this, appointment::class.java))
        }

        myPrescriptionsButton.setOnClickListener {
            startActivity(Intent(this, prescriptions::class.java))
        }

        healthReportButton.setOnClickListener {
            startActivity(Intent(this, health_report::class.java))
        }

        requestAssistanceButton.setOnClickListener {
            showRequestAssistancePopup()
        }

        // Handle the appointment text if passed from the appointment activity
        val upcomingAppointmentText: TextView = findViewById(R.id.upcomingappointment)
        val appointmentText = intent.getStringExtra("appointmentText")
        if (appointmentText != null) {
            upcomingAppointmentText.text = appointmentText
            upcomingAppointmentText.setBackgroundResource(R.drawable.homeappointment)
        }
    }

    private fun showRequestAssistancePopup() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.activity_request_assistance_popup, null)

        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}
