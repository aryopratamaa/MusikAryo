package com.aryo.musikaryo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
    }
}
