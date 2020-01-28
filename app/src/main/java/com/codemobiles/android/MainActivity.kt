package com.codemobiles.android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pixplicity.easyprefs.library.Prefs
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Load last logged-in username and password
        loadLastLoggedInUsernamePassword()

    }

    private fun loadLastLoggedInUsernamePassword() {

        val isLoggedIn = Prefs.getBoolean(Constants.IS_LOGGED_IN,false)
        if(isLoggedIn){
            val _username = Prefs.getString(Constants.COLUMN_USERNAME, "")
            val _password = Prefs.getString(Constants.COLUMN_PASSWORD, "")

            usernameEdittext.setText(_username)
            passwordEdittext.setText(_password)

        }
    }

    fun onClickLogin(view: View) {

        /*Toast.makeText(this, "Username : ${usernameEdittext.text.toString()} \nPassword : ${passwordEdittext.text.toString()}",
            Toast.LENGTH_SHORT
        ).show()*/

        val _username = Prefs.getString(Constants.COLUMN_USERNAME, "")
        val _password = Prefs.getString(Constants.COLUMN_PASSWORD, "")
        val username = usernameEdittext.text.toString()
        val passsword = passwordEdittext.text.toString()

        if (_username == username && _password == passsword) {
            Prefs.putBoolean(Constants.IS_LOGGED_IN,true)
            val i = Intent(this, SuccessActivity::class.java)
            startActivity(i)
        } else {
            Prefs.putBoolean(Constants.IS_LOGGED_IN,false)
            Toast.makeText(this, "Login failed!!!!", Toast.LENGTH_SHORT).show()
        }

    }

    fun onClickRegister(view: View) {
        val username = usernameEdittext.text.toString()
        val passsword = passwordEdittext.text.toString()
        Prefs.putString(Constants.COLUMN_USERNAME, username)
        Prefs.putString(Constants.COLUMN_PASSWORD, passsword)
        Toast.makeText(this, "Register successfully", Toast.LENGTH_SHORT).show()
    }
}
