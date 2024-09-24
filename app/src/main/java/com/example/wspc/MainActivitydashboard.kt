package com.example.wspc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivitydashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activitydashboard)

        val fullname = intent.getStringExtra("FULLNAME_EXTRA")
        val username = intent.getStringExtra("USERNAME_EXTRA")
        val tanggalLahir = intent.getStringExtra("TANGGAL_LAHIR_EXTRA")
        val email = intent.getStringExtra("EMAIL_EXTRA")
        val gender = intent.getStringExtra("GENDER_EXTRA")
        val nomorTelepon = intent.getStringExtra("NOMOR_TELEPON_EXTRA")
        val alamat = intent.getStringExtra("ALAMAT_EXTRA")
        val password = intent.getStringExtra("PASSWORD_EXTRA")

        findViewById<TextView>(R.id.textView2).text = username
        findViewById<TextView>(R.id.textView3).text = fullname
        findViewById<TextView>(R.id.lahir).text = tanggalLahir
        findViewById<TextView>(R.id.email).text = email
        findViewById<TextView>(R.id.gender).text = gender
        findViewById<TextView>(R.id.telp).text = nomorTelepon
        findViewById<TextView>(R.id.alamat).text = alamat

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.username)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}