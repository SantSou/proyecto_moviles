package com.example.proyecto_moviles.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_moviles.R

class Activity_Agendar: AppCompatActivity() {
    private lateinit var servicio: EditText
    private lateinit var stylist: EditText
    private lateinit var Date: EditText
    private lateinit var Hour: EditText
    private lateinit var schedule: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar)

        servicio = findViewById(R.id.Sevicio_Et)
        stylist = findViewById(R.id.estilista_Et)
        Date = findViewById(R.id.Fecha_Et)
        Hour = findViewById(R.id.Hora_Et)
        schedule = findViewById(R.id.schedule_button)
    }

}