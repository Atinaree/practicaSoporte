package com.example.practicasoporte

import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.practicasoporte.Constants.OPEN_PAGE
import com.example.practicasoporte.Constants.RECIVE_ID
import com.example.practicasoporte.Constants.SEND_ID



import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.*

class ChatActivity : AppCompatActivity() {
    private val TAG = "ChatActivity"

    //You can ignore this messageList if you're coming from the tutorial,
    // it was used only for my personal debugging
    var messagesList = mutableListOf<Message>()

    private lateinit var adapter: MessagingAdapter
    private val botList = listOf("Pedro", "Juan", "Valentina", "Isabella")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        recyclerView()

        clickEvents()

        val random = (0..3).random()
        customBotMessage("Hola! Soy ${botList[random]}, ¿Cómo puedo ayudarte?")
    }

    private fun clickEvents() {
        var rv_messages = findViewById<RecyclerView>(R.id.rv_messages)
        var et_message = findViewById<EditText>(R.id.et_message)
        var btn_send = findViewById<Button>(R.id.btn_send)
        //Send a message
        btn_send.setOnClickListener {
            sendMessage()
        }

        //Scroll back to correct position when user clicks on text view
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun recyclerView() {
        var rv_messages = findViewById<RecyclerView>(R.id.rv_messages)
        adapter = MessagingAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun onStart() {
        super.onStart()
        //In case there are messages, scroll to bottom when re-opening app
        GlobalScope.launch {
            var rv_messages = findViewById<RecyclerView>(R.id.rv_messages)
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun sendMessage() {
        var rv_messages = findViewById<RecyclerView>(R.id.rv_messages)
        var et_message = findViewById<EditText>(R.id.et_message)
        val message = et_message.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            messagesList.add(Message(message, SEND_ID, timeStamp))
            et_message.setText("")

            adapter.insertMessage(Message(message, SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }

    private fun botResponse(message: String) {
        val timeStamp = Time.timeStamp()

        GlobalScope.launch {
            //Fake response delay
            delay(1000)

            withContext(Dispatchers.Main) {
                //Gets the response
                val response = BotResponse.basicResponses(message)

                //Adds it to our local list
                messagesList.add(Message(response, RECIVE_ID, timeStamp))

                //Inserts our message into the adapter
                adapter.insertMessage(Message(response, RECIVE_ID, timeStamp))

                var rv_messages = findViewById<RecyclerView>(R.id.rv_messages)
                //Scrolls us to the position of the latest message
                rv_messages.scrollToPosition(adapter.itemCount - 1)

                //inicia la pagina de iberdrola
                when (response) {
                    OPEN_PAGE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.iberdrola.es/")
                        startActivity(site)
                    }
                }
            }
        }
    }

    private fun customBotMessage(message: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Time.timeStamp()
                var rv_messages = findViewById<RecyclerView>(R.id.rv_messages)
                messagesList.add(Message(message, RECIVE_ID, timeStamp))
                adapter.insertMessage(Message(message, RECIVE_ID, timeStamp))

                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}