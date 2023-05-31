package com.example.practicasoporte

class PreguntasProvaider {

    companion object {
        val listaPreguntas = listOf<Preguntas>(
            Preguntas(
                "¿Como puedo obtener una factura en concreto?",
                "Para ello debe dirigirse al apartado donde se muestran las facturas y pulsar el icono de filtrado, el cual le dirigirá a la pantalla donde se pueden filtrar las facturas"
            ),
            Preguntas(
                "¿Que debo hacer si no tengo luz?",
                "Se deberá poner en contacto con alguno de nuestros agentes o desde el apartado de Soporte tecnico de la App notificar la incidencia"
            ),
            Preguntas(
                "¿Cada cuánto tiempo recibiré mis facturas?",
                "Si el cliente tiene contratada una tarifa del mercado libre y tiene activada la factura electrónica, las facturas de Iberdrola le llegarán cada mes. Si el cliente no tiene activada la factura electrónica, independientemente de qué tipo de tarifa tenga contratada, tendrá que abonar la factura cada dos meses."
            ),
            Preguntas(
                "¿Necesito contador inteligente?",
                "Todos los Planes a Tu Medida salvo el Plan Estable y el Plan 3 periodos requieren tener un contador inteligente efectivamente integrado en el sistema, es decir, que seamos capaces de recibir en remoto el consumo horario con el objetivo de facturarle más baratas aquellas horas en las que tiene un precio promocionado."
            )
        )
    }
}