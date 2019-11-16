package com.example.proyecto_moviles.Activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_moviles.R
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import java.nio.file.Files.find
import android.widget.Toast

class ActivityProfile: AppCompatActivity() {
    private lateinit var btnAgendar: Button
    private lateinit var btnLogOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btnAgendar = find(R.id.profile_agenda_btn)
        btnLogOut = find(R.id.profile_change_user_btn)

        btnAgendar.setOnClickListener {
            Toast.makeText(this, "Selecciona los datos que se piden", Toast.LENGTH_LONG).show()
            startActivity<ActivityAgendar>()
        }

        btnLogOut.setOnClickListener {

            Toast.makeText(this, "Se ha cerrado tu sesiòn", Toast.LENGTH_LONG).show()
            startActivity<MainActivity>()
        }
    }
}