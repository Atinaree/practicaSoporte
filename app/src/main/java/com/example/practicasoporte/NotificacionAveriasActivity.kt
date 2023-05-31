package com.example.practicasoporte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.practicasoporte.databinding.ActivityNotificacionAveriasBinding

class NotificacionAveriasActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityNotificacionAveriasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificacionAveriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val aaAveria = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item)

        aaAveria.addAll(arrayListOf(
            baseContext.resources.getString(R.string.activity_notificacion_averias_spinnerItem1),
            baseContext.resources.getString(R.string.activity_notificacion_averias_spinnerItem2),
            baseContext.resources.getString(R.string.activity_notificacion_averias_spinnerItem3)))

        binding.spTipoAveria.adapter = aaAveria
    }
}