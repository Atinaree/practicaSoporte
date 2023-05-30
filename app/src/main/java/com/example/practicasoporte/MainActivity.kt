package com.example.practicasoporte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicasoporte.databinding.ActivityLoginBinding
import com.example.practicasoporte.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ayudaTV.setOnClickListener(){

            val intent = Intent(this, centroAyudaActivity::class.java)
            startActivity(intent)


        }
    }
}