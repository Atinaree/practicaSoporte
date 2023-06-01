package com.example.practicasoporte.Chat

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.practicasoporte.Chat.Constants.AGENTE
import com.example.practicasoporte.Chat.Constants.AVERIAS
import com.example.practicasoporte.Chat.Constants.OPEN_PAGE
import com.example.practicasoporte.Chat.Constants.PREGUNTAS
import com.example.practicasoporte.Chat.Constants.SALIR
import kotlinx.coroutines.delay
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when {

            //Hola
            message.contains("hola") || message.contains("buenas") -> {
                when (random) {
                    0 -> "Hola!, ¿en que puedo ayudarte?"
                    1 -> "Bienvenido al chat de asistencia,¿Que necesita hoy?"
                    2 -> "Buenos dias, ¿que necesita?"
                    else -> "error"
                }
            }

            //La hora
            message.contains("hora") && message.contains("?") && message.contains("es") && message.contains(
                "que"
            ) -> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }
            message.contains("1") -> {
                PREGUNTAS
            }
            message.contains("2") -> {
                AVERIAS
            }
            //Abre la pagina de iberdrola
            message.contains("3") -> {
                OPEN_PAGE
            }
            message.contains("4") -> {
                AGENTE
            }
            message.contains("5") -> {
                SALIR
            }
            //Cuando el bot no lo entiende
            else -> {
                when (random) {
                    0 -> "Lo siento, no puedo ayudarle con eso"
                    1 -> "No encuentro la respuesta"
                    2 -> "No le entiendo, pruebe de nuevo"
                    else -> "error"
                }
            }
        }
    }
}