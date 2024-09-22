package com.example.wspc

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivityRegis : AppCompatActivity() {
    private lateinit var etTanggal: EditText
    private lateinit var btnTanggal: ImageButton
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSubmit: Button
    private lateinit var spinnerGender: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_regis)

        etTanggal = findViewById(R.id.etTanggal)
        btnTanggal = findViewById(R.id.btnTanggal)
        etName = findViewById(R.id.editTextText3)
        etEmail = findViewById(R.id.editTextTextEmailAddress)
        etPassword = findViewById(R.id.editTextTextPassword)
        etConfirmPassword = findViewById(R.id.editTextTextPassword2)
        btnSubmit = findViewById(R.id.buttonSubmit)
        spinnerGender = findViewById(R.id.spinnerGender)

        // Setup Spinner untuk Gender
        val genderOptions = resources.getStringArray(R.array.gender_options)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter

        btnTanggal.setOnClickListener {
            showDatePicker()
        }

        etTanggal.setOnClickListener {
            showDatePicker()
        }

        btnSubmit.setOnClickListener {
            validateAndSubmit()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val tahun = calendar[Calendar.YEAR]
        val bulan = calendar[Calendar.MONTH]
        val tanggal = calendar[Calendar.DAY_OF_MONTH]
        val dialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                // Create a Calendar instance with the selected date
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)

                // Format the date
                val dateFormat = SimpleDateFormat("d MMMM yyyy", Locale("id")) // Use Indonesian locale
                val formattedDate = dateFormat.format(selectedDate.time)

                etTanggal.setText(formattedDate) // Set the formatted date to the EditText
            }, tahun, bulan, tanggal
        )
        dialog.show()
    }

    private fun validateAndSubmit() {
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val tanggal = etTanggal.text.toString()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        if (password != confirmPassword) {
            Toast.makeText(this, "Password dan Konfirmasi password harus sama", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_LONG).show()

        val intentDestination = Intent(this, MainActivityLogin::class.java).apply {
            putExtra("EMAIL_EXTRA", email)
            putExtra("PASSWORD_EXTRA", password)
        }
        startActivity(intentDestination)
    }
}
