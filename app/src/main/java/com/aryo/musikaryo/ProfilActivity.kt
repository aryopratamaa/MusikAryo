package com.aryo.musikaryo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val imgFoto = findViewById<ImageView>(R.id.imgFoto)
        val tvNama = findViewById<TextView>(R.id.tvNama)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnHome = findViewById<Button>(R.id.btnHome)

        imgFoto.setImageResource(R.drawable.aryo)
        tvNama.text = "Aryo Pratama"
        tvEmail.text = "mr.aryopratama@gmail.com"

        btnHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        val btnBack = findViewById<ImageView>(R.id.btnBackProfil)
        btnBack.setOnClickListener {
            finish()
        }


        val btnExit = findViewById<LinearLayout>(R.id.btnExit)
        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}
