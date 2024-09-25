package com.example.wspc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(private val mahasiswaList: List<Mahasiswa>) :
    RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    inner class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tvNama)
        val tvNim: TextView = itemView.findViewById(R.id.tvNim)
        val tvAlamat: TextView = itemView.findViewById(R.id.tvAlamat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswa = mahasiswaList[position]
        holder.tvNama.text = mahasiswa.nama
        holder.tvNim.text = mahasiswa.nim
        holder.tvAlamat.text = mahasiswa.alamat
    }

    override fun getItemCount(): Int {
        return mahasiswaList.size
    }
}
