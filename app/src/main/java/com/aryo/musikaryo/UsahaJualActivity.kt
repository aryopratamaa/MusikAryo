package com.aryo.musikaryo

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aryo.musikaryo.adapter.AlatMusikAdapter
import com.aryo.musikaryo.model.AlatMusik
import android.widget.ImageView

class UsahaJualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usaha_jual)

        val rv = findViewById<RecyclerView>(R.id.rvAlat)
        val btnProfil = findViewById<LinearLayout>(R.id.btnProfil)
        val btnExit = findViewById<LinearLayout>(R.id.btnExit)

        val data = listOf(
            AlatMusik(
                "Gitar Akustik",
                "Gitar dengan bodi kayu dan suara natural. Cocok untuk pemula maupun profesional.",
                R.drawable.gitar,
                "Rp 100.000"
            ),
            AlatMusik(
                "Gitar Elektrik",
                "Menggunakan pickup listrik untuk menghasilkan suara. Umumnya dipakai pada musik rock dan metal.",
                R.drawable.gitarlistrik,
                "Rp 200.000"
            ),
            AlatMusik(
                "Bass Elektrik",
                "Memiliki senar besar dengan nada rendah yang berfungsi sebagai pengatur ritme musik.",
                R.drawable.bass,
                "Rp 300.000"
            ),
            AlatMusik(
                "Keyboard",
                "Piano elektrik multifungsi dengan berbagai suara instrumen dan efek musik.",
                R.drawable.keyboard,
                "Rp 400.000"
            ),
            AlatMusik(
                "Drum Set",
                "Satu set instrumen perkusi yang terdiri dari bass drum, snare, tom, hi-hat, dan cymbal.",
                R.drawable.drum,
                "Rp 500.000"
            ),
            AlatMusik(
                "Biola",
                "Instrumen gesek klasik dengan empat senar. Banyak digunakan dalam musik orkestra dan tradisional.",
                R.drawable.biola,
                "Rp 600.000"
            ),
            AlatMusik(
                "Ukulele",
                "Instrumen kecil dengan 4 senar asal Hawaii, menghasilkan suara ceria dan ringan.",
                R.drawable.gitar,
                "Rp 700.000"
            ),
            AlatMusik(
                "Saxophone",
                "Alat musik tiup berbahan kuningan, sering digunakan dalam musik jazz, blues, dan klasik.",
                R.drawable.gitar,
                "Rp 800.000"
            )
        )

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = AlatMusikAdapter(data) { alat ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("NAMA", alat.nama)
            intent.putExtra("DESKRIPSI", alat.deskripsi)
            intent.putExtra("GAMBAR", alat.gambar)
            intent.putExtra("HARGA", alat.harga)
            startActivity(intent)
        }


        btnProfil.setOnClickListener {
            startActivity(Intent(this, ProfilActivity::class.java))
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }


    }
}
