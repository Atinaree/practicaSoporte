package com.example.practicasoporte

import com.example.practicasoporte.Constants.OPEN_PAGE
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Hola
            message.contains("Hola") -> {
                when (random) {
                    0 -> "Hola!, ¿en que puedo ayudarte?"
                    1 -> "Bienvenido al chat de asistencia,¿Que necesita hoy?"
                    2 -> "Buenos dias, ¿que necesita?"
                    else -> "error" }
            }

            //La hora
            message.contains("hora") && message.contains("?") && message.contains("es") && message.contains("que")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("abrir")-> {
                OPEN_PAGE
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