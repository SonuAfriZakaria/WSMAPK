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

        findViewById<TextView>(R.id.textView2).text = "USERNAME : $username"
        findViewById<TextView>(R.id.textView3).text = "NAMA : $fullname"
        findViewById<TextView>(R.id.lahir).text = "TANGGAL LAHIR : $tanggalLahir"
        findViewById<TextView>(R.id.email).text = "EMAIL : $email"
        findViewById<TextView>(R.id.gender).text = "GENDER : $gender"
        findViewById<TextView>(R.id.telp).text = "TELEPON : $nomorTelepon"
        findViewById<TextView>(R.id.alamat).text = "ALAMAT : $alamat"


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.username)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}