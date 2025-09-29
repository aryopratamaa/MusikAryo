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
            AlatMusik("Gitar Akustik", "Gitar dengan suara natural...", R.drawable.gitar),
            AlatMusik("Gitar Elektrik", "Cocok untuk musik rock...", R.drawable.gitarlistrik),
            AlatMusik("Bass Elektrik", "Instrumen nada rendah...", R.drawable.bass),
            AlatMusik("Keyboard", "Piano elektrik multifungsi...", R.drawable.keyboard),
            AlatMusik("Drum Set", "Alat musik perkusi lengkap...", R.drawable.drum),
            AlatMusik("Biola", "Instrumen gesek klasik...", R.drawable.biola),
            AlatMusik("Ukulele", "Alat musik kecil 4 senar...", R.drawable.gitar),
            AlatMusik("Saxophone", "Alat musik tiup jazzy...", R.drawable.gitar)
        )

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = AlatMusikAdapter(data) { alat ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("NAMA", alat.nama)
            intent.putExtra("DESKRIPSI", alat.deskripsi)
            intent.putExtra("GAMBAR", alat.gambar)
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
