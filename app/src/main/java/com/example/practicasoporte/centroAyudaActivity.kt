package com.example.practicasoporte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicasoporte.databinding.ActivityCentroAyudaBinding
import com.example.practicasoporte.databinding.ActivityLoginBinding

class centroAyudaActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityCentroAyudaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCentroAyudaBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.centroAyudaBtnPreguntasFrecuentes.setOnClickListener {
            val intent = Intent(this, PreguntasFrecuentesActivity::class.java)
            startActivity(intent)
        }

        binding.centroAyudaBtnAsistente.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

        binding.centroAyudaBtnNotificarAveria.setOnClickListener {
            val intent = Intent(this, NotificacionAveriasActivity::class.java)
            startActivity(intent)
        }

    }
}