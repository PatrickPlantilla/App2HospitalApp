package com.example.healthapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class appointment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        val homelogoButton: ImageButton = findViewById(R.id.hometoplogo)
        homelogoButton.setOnClickListener {
            startActivity(Intent(this, home::class.java))
        }

        // Set up click listeners for each doctor card
        findViewById<ImageButton>(R.id.annekaracard).setOnClickListener {
            showAppointmentPopup(
                R.drawable.drannekaracard,
                "Set up appointment?",
                "Appointment type: Liver Checkup",
                "You have a Liver Check Up soon."
            )
        }

        findViewById<ImageButton>(R.id.arkoracard).setOnClickListener {
            showAppointmentPopup(
                R.drawable.drarkoracard,
                "Set up appointment?",
                "Appointment type: Blood Test",
                "You have a Blood test soon."
            )
        }

        findViewById<ImageButton>(R.id.brianjohnsoncard).setOnClickListener {
            showAppointmentPopup(
                R.drawable.drbrianjohnsoncard,
                "Set up appointment?",
                "Appointment type: Kidney Check Up",
                "You have a Kidney check up soon."
            )
        }

        findViewById<ImageButton>(R.id.bruceerelycard).setOnClickListener {
            showAppointmentPopup(
                R.drawable.drbruceerelycard,
                "Set up appointment?",
                "Appointment type: Health Check Up",
                "You have a health check up soon."
            )
        }

        findViewById<ImageButton>(R.id.ivanilyncard).setOnClickListener {
            showAppointmentPopup(
                R.drawable.drivanilyncard,
                "Set up appointment?",
                "Appointment type: Allergies Check Up",
                "You have an Allergies check up soon."
            )
        }

        findViewById<ImageButton>(R.id.johnbincard).setOnClickListener {
            showAppointmentPopup(
                R.drawable.drjohnbincard,
                "Set up appointment?",
                "Appointment type: Skin Check Up",
                "You have a Skin check up soon."
            )
        }

        findViewById<ImageButton>(R.id.karengenoacard).setOnClickListener {
            showAppointmentPopup(
                R.drawable.drkarengenoacard,
                "Set up appointment?",
                "Appointment type: Health Check Up",
                "You have a check up soon."
            )
        }

        findViewById<ImageButton>(R.id.miravasylykcard).setOnClickListener {
            showAppointmentPopup(
                R.drawable.drmiravasylykcard,
                "Set up appointment?",
                "Appointment type: Bone Check Up",
                "You have a Bone check up soon."
            )
        }

        findViewById<ImageButton>(R.id.oscarearlandcard).setOnClickListener {
            showAppointmentPopup(
                R.drawable.droscarearlandcard,
                "Set up appointment?",
                "Appointment type: Medicine Prescription",
                "You have to collect your prescriptions soon."
            )
        }

        findViewById<ImageButton>(R.id.spencersmithcard).setOnClickListener {
            showAppointmentPopup(
                R.drawable.drspencersmithcard,
                "Set up appointment?",
                "Appointment type: Heart Check Up",
                "You have a Heart check up soon."
            )
        }
    }

    private fun showAppointmentPopup(imageResId: Int, setupText: String, typeText: String, homeText: String) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.activity_set_appointment_popup, null)

        val doctorCard: ImageView = dialogLayout.findViewById(R.id.doctorcard)
        val setupAppointment: TextView = dialogLayout.findViewById(R.id.setupappointment)
        val appointmentType: TextView = dialogLayout.findViewById(R.id.appointmenttype)
        val yesButton: ImageButton = dialogLayout.findViewById(R.id.yesappointment)
        val noButton: ImageButton = dialogLayout.findViewById(R.id.noappointment)

        doctorCard.setImageResource(imageResId)
        setupAppointment.text = setupText
        appointmentType.text = typeText

        builder.setView(dialogLayout)
        val dialog = builder.create()

        noButton.setOnClickListener {
            dialog.dismiss()
        }

        yesButton.setOnClickListener {
            val intent = Intent(this, home::class.java)
            intent.putExtra("appointmentText", homeText)
            startActivity(intent)
            dialog.dismiss()
        }

        dialog.show()
    }
}
