package com.example.practicasoporte.Chat

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicasoporte.Chat.Constants.RECIVE_ID
import com.example.practicasoporte.Chat.Constants.SEND_ID
import com.example.practicasoporte.R

class MessagingAdapter : RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {

    var messagesList = mutableListOf<Message>()

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                messagesList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messagesList[position]
        var tv_message = holder.itemView.findViewById<TextView>(R.id.tv_message)
        var tv_bot_message = holder.itemView.findViewById<TextView>(R.id.tv_bot_message)
        when (currentMessage.id) {
            SEND_ID -> {
                tv_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                tv_bot_message.visibility = View.GONE
            }
            RECIVE_ID -> {
                tv_bot_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                tv_message.visibility = View.GONE
            }
        }
    }

    fun insertMessage(message: Message) {
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
    }
}