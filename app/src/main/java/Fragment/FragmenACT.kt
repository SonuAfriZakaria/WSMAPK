package Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wspc.MainActivityRegis
import com.example.wspc.R
import com.example.wspc.listMahasiswa
import com.example.wspc.recycle

class FragmenACT : AppCompatActivity()
    {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragmen)


        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        button1.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, Frame1())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        button2.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, Fragmen2())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        button3.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, Fragmen3())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }
}