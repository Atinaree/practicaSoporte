package com.example.practicasoporte

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.practicasoporte.databinding.ItemViewBinding

class PreguntasViewHolder(view: View): RecyclerView.ViewHolder(view){

    val binding = ItemViewBinding.bind(view)

    fun render(preguntas: Preguntas){

        binding.preguntasFrecuentesTvTituloPregunta.text = preguntas.pregunta
        binding.preguntasFrecuentesTvCuerpoPregunta.text = preguntas.cuerpoPregunta
        binding.preguntasFrecuentesBtnDeplegarCuerpoPregunta.setOnClickListener(){
            if(binding.preguntasFrecuentesTvCuerpoPregunta.visibility == View.GONE){
                binding.preguntasFrecuentesTvCuerpoPregunta.visibility = View.VISIBLE
                binding.preguntasFrecuentesBtnDeplegarCuerpoPregunta.setImageResource(R.drawable.flecha_arriba)
            }else{
                binding.preguntasFrecuentesTvCuerpoPregunta.visibility = View.GONE
                binding.preguntasFrecuentesBtnDeplegarCuerpoPregunta.setImageResource(R.drawable.flecha_bajo)
            }

        }
    }

}