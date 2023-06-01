package com.example.practicasoporte.PreguntasFrecuentes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicasoporte.centroAyudaActivity
import com.example.practicasoporte.databinding.ActivityPreguntasFrecuentesBinding

class PreguntasFrecuentesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreguntasFrecuentesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreguntasFrecuentesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.preguntasFrecuentesToolbarImgBtnSalir.setOnClickListener(){
        finish()
        }
        initReciclerView()
    }

    fun initReciclerView(){
        binding.preguntasFrecuentesRecyclerViewPreguntas.layoutManager = LinearLayoutManager(this)
        binding.preguntasFrecuentesRecyclerViewPreguntas.adapter = PreguntasAdapter(PreguntasProvider.listaPreguntas)
    }
}