package Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wspc.Mahasiswa
import com.example.wspc.MahasiswaAdapter
import com.example.wspc.R

class Fragmen2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragmen2, container, false)

        // Access RecyclerView from the fragment's layout
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        // Create a list of Mahasiswa objects
        val mahasiswaList = listOf(
            Mahasiswa("Aziz", "E41232442", "Bondowoso"),
            Mahasiswa("Mafira", "E41232457", "Bondowoso"),
            Mahasiswa("Solli", "E41232305", "Bondowoso"),
            Mahasiswa("Sonu", "E41232319", "Bondowoso"),
            Mahasiswa("Wafi", "E41232434", "Bondowoso"),
            Mahasiswa("Septian", "E41230866", "Bondowoso"),
            Mahasiswa("Mohammad", "E41233124", "Bondowoso"),
            Mahasiswa("Febri", "E4122431", "Bondowoso"),
            Mahasiswa("Galoh", "E4123156", "Bondowoso"),
            Mahasiswa("Afriza", "E4123215", "Bondowoso"),
            Mahasiswa("Muhammad", "E414215", "Bondowoso"),
            Mahasiswa("Sepan", "E4151234", "Bondowoso"),
            Mahasiswa("ASep", "E4312535", "Bondowoso"),
            Mahasiswa("Tian", "E41230321", "Bondowoso"),
        )

        // Set LayoutManager dan Adapter untuk RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MahasiswaAdapter(mahasiswaList)

        return view
    }
}
