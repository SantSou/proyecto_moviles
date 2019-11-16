package com.example.proyecto_moviles

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_moviles.Fragments.DatePickerFragment
import com.example.proyecto_moviles.Fragments.TimePickerFragment
import org.jetbrains.anko.find

class ActivityAgendar : AppCompatActivity(){

    private lateinit var etDate : EditText
    private lateinit var etTime : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar)

        etDate = find(R.id.Fecha_Et)
        etTime = find(R.id.Hora_Et)

        etDate.setOnClickListener(){
            showDatePickerDialog()
        }

        etTime.setOnClickListener(){
            showTimePickerDialog()
        }
    }


   // override fun onClick(v: View?) {
     //   when(v?.id){
       //     R.id.Fecha_Et ->{
          //     showDatePickerDialog()
         //  }
        //}
    //}

    private fun showDatePickerDialog(){
        val newFragment = DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, day ->

            //Enero es 0
            val selectDate = day.toString() + "/" + (month+1) + "/" + year
            etDate.setText(selectDate)

        }, this)
        newFragment.show(supportFragmentManager, "datePicker")
    }

    private fun showTimePickerDialog(){
        val newFragment = TimePickerFragment.newInstance(TimePickerDialog.OnTimeSetListener{_, hour, min ->
           //0 son las 00hrs
           val selectTime = hour.toString() + ":" + min.toString()
           etTime.setText(selectTime)

        }, this)

        newFragment.show(supportFragmentManager, "TimePicker")
    }
}