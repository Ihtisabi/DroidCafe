package com.example.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Inisialisasi Spinner
        val spinner: Spinner = findViewById(R.id.city_spinner) // Ganti my_spinner dengan ID yang sesuai
        // Buat adapter menggunakan array dari strings.xml
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_items, // Pastikan array ini ada di strings.xml
            android.R.layout.simple_spinner_item
        )
        // Tentukan layout untuk dropdown saat Spinner terbuka
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Pasang adapter ke Spinner
        spinner.adapter = adapter
    }


    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.sameday -> if (checked) // Same day service
                displayToast(getString(R.string.same_day_messenger_service))


            R.id.nextday -> if (checked) // Next day delivery
                displayToast(getString(R.string.next_day_ground_delivery))


            R.id.pickup -> if (checked) // Pick up
                displayToast(getString(R.string.pick_up))


            else -> {}
        }
    }


    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }
}
