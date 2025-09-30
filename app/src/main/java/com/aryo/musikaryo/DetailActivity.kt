package com.aryo.musikaryo

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val img = findViewById<ImageView>(R.id.imgDetail)
        val tvNama = findViewById<TextView>(R.id.tvNamaDetail)
        val tvDesk = findViewById<TextView>(R.id.tvDeskripsiDetail)
        val tvHarga = findViewById<TextView>(R.id.tvHargaDetail)
        val btnKembali = findViewById<ImageView>(R.id.btnKembali)

        val nama = intent.getStringExtra("NAMA")
        val desk = intent.getStringExtra("DESKRIPSI")
        val gambar = intent.getIntExtra("GAMBAR", 0)
        val harga = intent.getStringExtra("HARGA") ?: "-"

        img.setImageResource(gambar)
        tvNama.text = nama
        tvDesk.text = desk
        tvHarga.text = "Harga: $harga"

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

        val btnBeli = findViewById<Button>(R.id.btnBeli)
        btnBeli.setOnClickListener {
            val noHp = "6282161965317" // ganti dengan nomor admin
            val pesan = "Halo, saya tertarik dengan produk $nama seharga $harga"
            val url = "https://wa.me/$noHp?text=${Uri.encode(pesan)}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        val icInstagram = findViewById<ImageView>(R.id.icInstagram)
        icInstagram.setOnClickListener {
            val uri = Uri.parse("https://www.instagram.com/aryopratamaa")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.instagram.android")
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }

        val icWhatsapp = findViewById<ImageView>(R.id.icWhatsapp)
        icWhatsapp.setOnClickListener {
            val noHp = "6282161965317"
            val pesan = "Halo, saya ingin menanyakan tentang $nama"
            val url = "https://wa.me/$noHp?text=${Uri.encode(pesan)}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        val icFacebook = findViewById<ImageView>(R.id.icFacebook)
        icFacebook.setOnClickListener {
            val uri = Uri.parse("https://www.facebook.com/aryopratama04082000")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.facebook.katana")
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
    }
}
