package com.aryo.musikaryo

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
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

        val btnInstagram = findViewById<ImageButton>(R.id.btnInstagram)
        btnInstagram.setOnClickListener {
            val akunInstagram = Uri.parse("https://www.instagram.com/aryopratamaa")
            val intent = Intent(Intent.ACTION_VIEW, akunInstagram)
            intent.setPackage("com.instagram.android")
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, akunInstagram)
                )
            }
        }

        val btnFacebook = findViewById<ImageButton>(R.id.btnFacebook)
        btnFacebook.setOnClickListener {
            val akunFacebook = Uri.parse("https://www.facebook.com/aryopratama04082000")
            val intent = Intent(Intent.ACTION_VIEW, akunFacebook)
            intent.setPackage("com.facebook.android")
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, akunFacebook)
                )
            }
        }

        val btnWhatsapp = findViewById<ImageView>(R.id.btnWhatsapp)
        val noHp = "6282161965317"
        val teks = "Halo, saya ingin menanyakan tentang layanan penyewaan sound system."
        btnWhatsapp.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/$noHp?text=$teks")
            startActivity(intent)
        }


    }
}
