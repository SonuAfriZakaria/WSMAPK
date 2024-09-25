package com.example.wspc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class recycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val mahasiswaList = listOf(
            Mahasiswa("Aziz", "E41232442", "Bondowoso"),
            Mahasiswa("Mafira", "E41232457", "Bondowoso"),
            Mahasiswa("Solli", "E41232305", "Bondowoso"),
            Mahasiswa("Sonu", "E41232319", "Bondowoso"),
            Mahasiswa("Wafi", "E41232434", "SBondowoso"),
            Mahasiswa("Septian", "E41230866", "Bondowoso"),
            Mahasiswa("Mohammad", "E41233124", "Bondowoso"),
            Mahasiswa("Febri", "E4122431", "Bondowoso"),
            Mahasiswa("Galoh", "E4123156", "Bondowoso"),
            Mahasiswa("Afriza", "E4123215", "Bondowoso"),
            Mahasiswa("Muhammad", "E414215", "Bondowoso"),
            Mahasiswa("Sepan", "E4151234", "Bondowoso"),
            Mahasiswa("ASep", "E4312535", "Bondowoso"),
            Mahasiswa("tian", "E41230321", "Bondowoso"),

        )

        // Set LayoutManager dan Adapter untuk RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MahasiswaAdapter(mahasiswaList)
    }
}