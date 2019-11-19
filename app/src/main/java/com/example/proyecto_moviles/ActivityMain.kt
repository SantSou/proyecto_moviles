package com.example.proyecto_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.parse.ParseUser
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import java.nio.file.Files.find

class ActivityMain : AppCompatActivity(), View.OnClickListener {

    private lateinit var mEditSchedule: Button
    private lateinit var mEditServices: Button
    private lateinit var mChangeUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        mEditSchedule = findViewById(R.id.options_edit_schedule_btn)
        mEditServices = findViewById(R.id.options_edit_services_btn)
        mChangeUser = findViewById(R.id.options_change_user)

        mEditSchedule.setOnClickListener(this)
        mEditServices.setOnClickListener(this)
        mChangeUser.setOnClickListener(this)

    }

    override fun onClick(item: View?) {
        when(item?.id) {
            R.id.options_edit_schedule_btn -> {
                //startActivity<ActivityEditSchedule>()
            }
            R.id.options_edit_services_btn -> {
                startActivity<ActivityEditServices>()
            }
            R.id.options_change_user -> {
                ParseUser.getCurrentUser()
                ParseUser.logOut()
                startActivity<ActivityLogin>()
            }
        }
    }
}
