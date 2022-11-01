package com.example.registrationform

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bestcalculator.Login
import com.example.bestcalculator.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var name_input:EditText
    private lateinit var email_input:EditText
    private lateinit var phone_input:EditText
    private lateinit var password_input:EditText
    private lateinit var btn_login:Button
    private lateinit var btn_register:Button
    private var mAuth:FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var firebaseDatabase= FirebaseDatabase.getInstance()
        var databaseReference = firebaseDatabase.reference

        mAuth = FirebaseAuth.getInstance()

        name_input= findViewById(R.id.firstnamedt)
        email_input= findViewById(R.id.emailedt)
        phone_input= findViewById(R.id.edtPhone)
        password_input= findViewById(R.id.edtPassword)
        btn_login= findViewById(R.id.button3)
        btn_register= findViewById(R.id.button)
        btn_login.setOnClickListener {
            var intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
        btn_register.setOnClickListener {
            var email = email_input.text.toString().trim()
            var password = password_input.text.toString().trim()

            mAuth!!.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task: Task<AuthResult> ->
                    if (task.isSuccessful) {

                        Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
                        var inntent=Intent(this, Login::class.java)
                        startActivity(inntent)
                        finish()

                    } else {

                        Toast.makeText(this, "Failed to Create Account", Toast.LENGTH_SHORT).show()
                        Log.d("Error==>", task.exception.toString())
                    }
                }

        }

    }

}















