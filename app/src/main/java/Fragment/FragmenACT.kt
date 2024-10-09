package Fragment

import Fragment.Fragmen2
import Fragment.Fragmen3
import Fragment.Frame1
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.wspc.R
import com.google.android.material.bottomnavigation.BottomNavigationView

public class FragmenACT : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmen) // Ganti dengan layout kamu

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.Nvabar)

        // Set fragment default
        loadFragment(Frame1())
        loadFragment(Fragmen2())
        loadFragment(Fragmen3())

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val selectedFragment: Fragment? = when (item.itemId) {
                R.id.ImageButton -> Frame1()
                R.id.ImageButton2 -> Fragmen2()
                R.id.ImageButton3 -> Fragmen3()
                else -> null
            }

            loadFragment(selectedFragment)
        }
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        // Ganti fragment jika tidak null
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }
}
