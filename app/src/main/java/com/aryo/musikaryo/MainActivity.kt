package com.aryo.musikaryo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgJual = findViewById<ImageView>(R.id.imgJual)
        val imgSewa = findViewById<ImageView>(R.id.imgSewa)
        val btnProfil = findViewById<LinearLayout>(R.id.btnProfil)
        val btnExit = findViewById<LinearLayout>(R.id.btnExit)

        imgJual.setOnClickListener {
            startActivity(Intent(this, UsahaJualActivity::class.java))
        }

        imgSewa.setOnClickListener {
            startActivity(Intent(this, UsahaSewaActivity::class.java))
        }

        btnProfil.setOnClickListener {
            startActivity(Intent(this, ProfilActivity::class.java))
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}
