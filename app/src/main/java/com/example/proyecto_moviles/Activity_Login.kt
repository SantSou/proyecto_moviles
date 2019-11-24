package com.example.proyecto_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.find
import android.content.Context
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.example.proyecto_moviles.activities.Activity_Profile
import com.example.proyecto_moviles.utils.*
import com.parse.ParseObject
import com.parse.ParseQuery
import org.jetbrains.anko.startActivity



class Activity_Login : AppCompatActivity() {

    private lateinit var mLogin: Button
    private lateinit var mUserName: EditText
    private lateinit var mPassword: EditText
    private lateinit var mParseTest: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLogin = find(R.id.login_sign_in_button)
        mUserName = find(R.id.login_userName_et)
        mPassword = find(R.id.login_password_et)
        mParseTest = find(R.id.Parsetest)


        mLogin.setOnClickListener {
            val query = ParseQuery.getQuery<ParseObject>("Service")
            query.whereEqualTo("objectId", "9BW0ZDWZyx")
            query.getFirstInBackground { obj, e ->
                if (e == null) {
                    mParseTest.text = obj.objectId
                }
            }
            //startActivity<Activity_Profile>()
            /*//Prueba de conexión con Parse
            val query = ParseQuery<ParseObject>("Service")
            query.whereEqualTo("objectId", "9BW0ZDWZyx")
            query.addDescendingOrder("createdAt")
            query.getFirstInBackground { obj, e ->
                if (e == null){
                    startActivity<Activity_Profile>()
                    mParseTest.text = obj["objectId"] as String
                } else {
                    error { "Error $e" }  // Log.e using anko
                  }
            }
            */

            /* //Login
             ParseUser.logInInBackground(mUserName.text.toString(), mPassword.text.toString()) { parseUser, error ->
                 if (error == null) {
                     saveSessionToken(parseUser.sessionToken)
                     startActivity<Activity_Profile>()
                 } else {
                     ParseUser.logOut()
                     Toast.makeText(this, "Login error", Toast.LENGTH_LONG).show()
                 }
             }
             */
        }
    }


    //////POSSIBLE FUNCTION TO IMPLEMENT IN THE FUTURE

    fun saveSessionToken(sessionToken: String) {
        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(SESSION_ID_KEY, sessionToken)
        editor.apply()
    }
}