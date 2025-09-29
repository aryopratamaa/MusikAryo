package com.aryo.musikaryo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.LinearLayout

class UsahaSewaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usaha_sewa)

        val tvInfo = findViewById<TextView>(R.id.tvInfoSewa)
        val btnProfil = findViewById<LinearLayout>(R.id.btnProfil)
        val btnExit = findViewById<LinearLayout>(R.id.btnExit)

        tvInfo.text = "Kami menyediakan layanan penyewaan sound system untuk acara pernikahan, konser, ulang tahun, dan event lainnya. Paket lengkap dengan teknisi berpengalaman."

        btnProfil.setOnClickListener {
            startActivity(Intent(this, ProfilActivity::class.java))
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }

        val btnBack = findViewById<ImageView>(R.id.btnBackSewa)
        btnBack.setOnClickListener {
            finish()
        }


    }
}
