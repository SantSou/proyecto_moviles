package com.example.proyecto_moviles

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_moviles.Fragments.DatePickerFragment
import org.jetbrains.anko.find

class ActivityAgendar : AppCompatActivity(){

    private lateinit var etDate : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar)

        etDate = find(R.id.Fecha_Et)

        etDate.setOnClickListener(){
            showDatePickerDialog()
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

        })
        newFragment.show(supportFragmentManager, "datePicker")
    }
}