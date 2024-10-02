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
    private lateinit var etFullname : EditText
    private lateinit var etTelp : EditText
    private lateinit var etAlamat : EditText
    private lateinit var buttonShowHide: ImageButton
    private lateinit var buttonShowHide1: ImageButton
    private var isPasswordVisible = false

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
        etFullname = findViewById(R.id.editTextText4)
        etTelp = findViewById(R.id.editTextNumberSigned)
        etAlamat = findViewById(R.id.editTextText6)
        buttonShowHide = findViewById(R.id.buttonShowHide)
        buttonShowHide1 = findViewById(R.id.buttonShowHide1)



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
        buttonShowHide.setOnClickListener {
            togglePasswordVisibility()
        }
        buttonShowHide1.setOnClickListener {
            togglePasswordVisibility1()
        }
    }

    private fun togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible
        etPassword.transformationMethod = if (isPasswordVisible) {
            null // Show password
        } else {
            android.text.method.PasswordTransformationMethod.getInstance()
        }
        etPassword.setSelection(etPassword.text.length)
    }

    private fun togglePasswordVisibility1() {
        isPasswordVisible = !isPasswordVisible
        etConfirmPassword.transformationMethod = if (isPasswordVisible) {
            null // Show password
        } else {
            android.text.method.PasswordTransformationMethod.getInstance()
        }
        etConfirmPassword.setSelection(etConfirmPassword.text.length)
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val tahun = calendar[Calendar.YEAR]
        val bulan = calendar[Calendar.MONTH]
        val tanggal = calendar[Calendar.DAY_OF_MONTH]
        val dialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("d MMMM yyyy", Locale("id")) // Use Indonesian locale
                val formattedDate = dateFormat.format(selectedDate.time)

                etTanggal.setText(formattedDate)
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
        val fullname = etFullname.text.toString()
        val nomor = etTelp.text.toString()
        val alamat = etAlamat.text.toString()
        val gender = spinnerGender.selectedItem.toString()

        if (password != confirmPassword) {
            Toast.makeText(this, "Password dan Konfirmasi password harus sama", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_LONG).show()

        val intentDestination = Intent(this, MainActivityLogin::class.java).apply {
            putExtra("FULLNAME_EXTRA", fullname)
            putExtra("USERNAME_EXTRA", name)
            putExtra("TANGGAL_LAHIR_EXTRA", tanggal)
            putExtra("EMAIL_EXTRA", email)
            putExtra("GENDER_EXTRA", gender)
            putExtra("NOMOR_TELEPON_EXTRA", nomor)
            putExtra("ALAMAT_EXTRA", alamat)
            putExtra("PASSWORD_EXTRA", password)
        }
        startActivity(intentDestination)
    }
}
