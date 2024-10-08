package com.example.wspc

import Fragment.FragmenACT
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AlertDialog
import android.content.Intent

class MainActivityLogin : AppCompatActivity() {

    private lateinit var editTextTextEmailAddress2: EditText
    private lateinit var editTextPassword3: EditText
    private lateinit var buttonShowHide: ImageButton
    private lateinit var buttonLogin: Button
    private var isPasswordVisible = false
    private var registeredPassword: String? = null
    private lateinit var sharedPreferences: SharedPreferences
    private val sharedPrefFile = "user_prefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_login)

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE)

        editTextTextEmailAddress2 = findViewById(R.id.editTextTextEmailAddress2)
        editTextPassword3 = findViewById(R.id.editTextTextPassword3)
        buttonShowHide = findViewById(R.id.buttonShowHide)
        buttonLogin = findViewById(R.id.buttonLogin)

        // Cek SharedPreferences untuk login otomatis
        val savedEmail = sharedPreferences.getString("EMAIL_EXTRA", null)
        val savedPassword = sharedPreferences.getString("PASSWORD_EXTRA", null)

        if (savedEmail != null && savedPassword != null) {
            // Jika sudah terdaftar, langsung buka FragmenACT
            val intentDestination = Intent(this, FragmenACT::class.java).apply {
                putExtra("EMAIL_EXTRA", savedEmail)
                putExtra("PASSWORD_EXTRA", savedPassword)
            }
            startActivity(intentDestination)
            finish() // Tutup MainActivityLogin
            return
        }

        // Jika belum terdaftar, lanjutkan dengan logika normal
        val email = intent.getStringExtra("EMAIL_EXTRA")
        registeredPassword = intent.getStringExtra("PASSWORD_EXTRA")
        email?.let {
            editTextTextEmailAddress2.setText(it)
        }

        buttonShowHide.setOnClickListener {
            togglePasswordVisibility()
        }

        buttonLogin.setOnClickListener {
            validateLogin()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.username)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible
        editTextPassword3.transformationMethod = if (isPasswordVisible) {
            null // Show password
        } else {
            android.text.method.PasswordTransformationMethod.getInstance()
        }

        buttonShowHide.setImageResource(if (isPasswordVisible) {
            R.drawable.baseline_remove_red_eye_24
        } else {
            R.drawable.baseline_panorama_fish_eye_24
        })

        editTextPassword3.setSelection(editTextPassword3.text.length)
    }

    private fun validateLogin() {
        val enteredPassword = editTextPassword3.text.toString()
        val fullname = intent.getStringExtra("FULLNAME_EXTRA")
        val name = intent.getStringExtra("USERNAME_EXTRA")
        val tanggal = intent.getStringExtra("TANGGAL_LAHIR_EXTRA")
        val gender = intent.getStringExtra("GENDER_EXTRA")
        val nomor = intent.getStringExtra("NOMOR_TELEPON_EXTRA")
        val alamat = intent.getStringExtra("ALAMAT_EXTRA")
        val email = intent.getStringExtra("EMAIL_EXTRA")

        if (enteredPassword == registeredPassword) {
            // Simpan data pengguna ke SharedPreferences
            with(sharedPreferences.edit()) {
                putString("EMAIL_EXTRA", email)
                putString("PASSWORD_EXTRA", registeredPassword)
                apply()
            }

            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intentDestination = Intent(this, FragmenACT::class.java).apply {
                putExtra("FULLNAME_EXTRA", fullname)
                putExtra("USERNAME_EXTRA", name)
                putExtra("TANGGAL_LAHIR_EXTRA", tanggal)
                putExtra("EMAIL_EXTRA", email)
                putExtra("GENDER_EXTRA", gender)
                putExtra("NOMOR_TELEPON_EXTRA", nomor)
                putExtra("ALAMAT_EXTRA", alamat)
            }
            startActivity(intentDestination)
            finish() // Tutup MainActivityLogin
        } else {
            showAlertDialog("Peringatan", "Password salah")
        }
    }

    private fun showAlertDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("Lanjut") { dialog, _ ->
                dialog.dismiss()
                val intent = Intent(this, listMahasiswa::class.java)
                startActivity(intent)
            }
            .setNegativeButton("Tetap Dihalaman") { dialog, _ ->
                dialog.dismiss()
            }
        val dialog = builder.create()
        dialog.show()
    }
}
