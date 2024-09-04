package com.example.wspc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


            button1 = findViewById(R.id.button1)

            button1.setOnClickListener {
                val intentDestination = Intent( this@MainActivity, MainActivityRegis::class.java)
                startActivity(intentDestination)
            }

        }
    }