package com.example.practicasoporte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicasoporte.databinding.ActivityPreguntasFrecuentesBinding

class PreguntasFrecuentesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreguntasFrecuentesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreguntasFrecuentesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initReciclerView()
    }

    fun initReciclerView(){
        binding.preguntasFrecuentesRecyclerViewPreguntas.layoutManager = LinearLayoutManager(this)
        binding.preguntasFrecuentesRecyclerViewPreguntas.adapter = PreguntasAdapter(PreguntasProvider.listaPreguntas)
    }
}