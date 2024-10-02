package Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
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
    private lateinit var imageButton: ImageButton
    private lateinit var imageButton2: ImageButton
    private lateinit var imageButton3: ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragmen)


        imageButton = findViewById(R.id.imageButton)
        imageButton2 = findViewById(R.id.imageButton2)
        imageButton3 = findViewById(R.id.imageButton3)

        imageButton.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, Frame1())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        imageButton3.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, Fragmen2())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        imageButton2.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, Fragmen3())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }
}