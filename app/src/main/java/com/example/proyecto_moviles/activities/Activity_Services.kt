package com.example.proyecto_moviles.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_moviles.R
import com.example.proyecto_moviles.adapters.AdapterService
import com.parse.ParseObject
import com.parse.ParseQuery
import org.jetbrains.anko.*
import kotlin.random.Random

class Activity_Services : AppCompatActivity(){

    private lateinit var addServiceButton: Button
    private lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        val recyclerView = findViewById<RecyclerView>(R.id.services_RecyclerView)
        val services = arrayListOf<String>()

        //recyclerView.adapter = AdapterService(getParseServices())
        //recyclerView.layoutManager = LinearLayoutManager(this)

        addServiceButton = findViewById(R.id.AddService_button_activityServices)
        doneButton = findViewById(R.id.Done_button_activityServices)

        addServiceButton.setOnClickListener(){
            startActivity<Activity_newService>()
        }

        doneButton.setOnClickListener(){
            startActivity<ActivityMain>()
        }


        /********************************************************************
         * IMPLEMENT PARSE FETCH SERVICES HERE
         * *******************************************************************
         */

        val service: String
        val ParseObject = ParseObject("Service")
        val query = ParseQuery.getQuery<ParseObject>("Service")
        query.getFirstInBackground { obj, e ->
            if (e == null) {
                services.add(obj.get("NameOfService") as String)
                recyclerView.adapter = AdapterService(services)
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
        }
    }

    /*
    fun getParseServices() : ArrayList<ParseObject> {
        val service: String
        val services = arrayListOf<ParseObject>()
        val ParseObject = ParseObject("Service")
        val query = ParseQuery.getQuery<ParseObject>("Service")
        query.getFirstInBackground { obj, e ->
            if (e == null) {
                services.add(obj)
                //recyclerView.adapter = AdapterService(services)
                //recyclerView.layoutManager = LinearLayoutManager(this)
            }
        }
        return services
    }

     */
}