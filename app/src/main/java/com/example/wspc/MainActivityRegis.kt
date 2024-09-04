package com.example.wspc

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivityRegis : AppCompatActivity() {
    private var etTanggal: EditText? = null
    private var btnTanggal: ImageButton? = null
    private var etName: EditText? = null
    private var etEmail: EditText? = null
    private var btnSubmit: Button? = null
    private var spinnerGender: Spinner? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_regis)

        etTanggal = findViewById(R.id.etTanggal)
        btnTanggal = findViewById(R.id.btnTanggal)
        etName = findViewById(R.id.editTextText3)
        etEmail = findViewById(R.id.editTextTextEmailAddress)
        btnSubmit = findViewById(R.id.buttonSubmit)
        spinnerGender = findViewById(R.id.spinnerGender)


        val genderOptions = resources.getStringArray(R.array.gender_options)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender?.adapter = adapter

        btnTanggal?.setOnClickListener {
            val calendar = Calendar.getInstance()
            val tahun = calendar[Calendar.YEAR]
            val bulan = calendar[Calendar.MONTH]
            val tanggal = calendar[Calendar.DAY_OF_MONTH]
            val dialog = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    etTanggal?.setText("$dayOfMonth - ${month + 1} - $year")
                }, tahun, bulan, tanggal
            )
            dialog.show()
        }

        etTanggal?.setOnClickListener {
            val calendar = Calendar.getInstance()
            val tahun = calendar[Calendar.YEAR]
            val bulan = calendar[Calendar.MONTH]
            val tanggal = calendar[Calendar.DAY_OF_MONTH]
            val dialog = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    etTanggal?.setText("$dayOfMonth - ${month + 1} - $year")
                }, tahun, bulan, tanggal
            )
            dialog.show()
        }

        btnSubmit?.setOnClickListener {
            val name = etName?.text.toString()
            val email = etEmail?.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty()) {
                Toast.makeText(this, "Registrasi berhasil dengan Nama: $name\nEmail: $email", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "Name and Email cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }


}


