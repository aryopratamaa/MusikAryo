package com.aryo.musikaryo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aryo.musikaryo.R
import com.aryo.musikaryo.model.AlatMusik

class AlatMusikAdapter(
    private val list: List<AlatMusik>,
    private val onItemClick: (AlatMusik) -> Unit
) : RecyclerView.Adapter<AlatMusikAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgAlat)
        val tvNama: TextView = view.findViewById(R.id.tvNamaAlat)
        val tvDeskripsi: TextView = view.findViewById(R.id.tvDeskripsiAlat)
        lateinit var tvHarga: String

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alat_musik, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alat = list[position]
        holder.img.setImageResource(alat.gambar)
        holder.tvNama.text = alat.nama
        holder.tvDeskripsi.text = alat.deskripsi
        holder.tvHarga = alat.harga

        holder.itemView.setOnClickListener {
            onItemClick(alat)
        }
    }

    override fun getItemCount(): Int = list.size
}
