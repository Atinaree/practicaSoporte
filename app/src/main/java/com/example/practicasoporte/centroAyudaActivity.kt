package com.example.practicasoporte

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
    }
}