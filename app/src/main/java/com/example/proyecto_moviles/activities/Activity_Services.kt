package com.example.proyecto_moviles.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_moviles.R
import com.example.proyecto_moviles.adapters.AdapterService
import org.jetbrains.anko.*
import kotlin.random.Random

class Activity_Services : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        val recyclerView = findViewById<RecyclerView>(R.id.services_RecyclerView)
        val services = arrayListOf<HashMap<String, String>>()

        recyclerView.adapter = AdapterService(services)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}