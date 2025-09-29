package com.aryo.musikaryo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val img = findViewById<ImageView>(R.id.imgDetail)
        val tvNama = findViewById<TextView>(R.id.tvNamaDetail)
        val tvDesk = findViewById<TextView>(R.id.tvDeskripsiDetail)
        val btnKembali = findViewById<ImageView>(R.id.btnKembali)

        val nama = intent.getStringExtra("NAMA")
        val desk = intent.getStringExtra("DESKRIPSI")
        val gambar = intent.getIntExtra("GAMBAR", 0)

        img.setImageResource(gambar)
        tvNama.text = nama
        tvDesk.text = desk

        btnKembali.setOnClickListener {
            finish()
        }

        val btnExit = findViewById<LinearLayout>(R.id.btnExit)
        btnExit.setOnClickListener {
            finishAffinity()
        }

        val btnProfil = findViewById<LinearLayout>(R.id.btnProfil)
        btnProfil.setOnClickListener {

            try {
                val intent = Intent(this, ProfilActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Halaman Profil belum tersedia", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
