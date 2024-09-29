package com.example.wspc

import Fragment.FragmenACT
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


            button1 = findViewById(R.id.button1)
            button2 = findViewById(R.id.button2)
            button3 = findViewById(R.id.button3)
            button4 = findViewById(R.id.button4)

            button1.setOnClickListener {
                val intentDestination = Intent( this@MainActivity, MainActivityRegis::class.java)
                startActivity(intentDestination)
            }
        button2.setOnClickListener {
            val intentDestination = Intent( this@MainActivity, listMahasiswa::class.java)
            startActivity(intentDestination)
        }
        button3.setOnClickListener {
            val intentDestination = Intent( this@MainActivity, recycle::class.java)
            startActivity(intentDestination)
        }
        button4.setOnClickListener {
            val intentDestination = Intent( this@MainActivity, FragmenACT::class.java)
            startActivity(intentDestination)
        }

        }
    }