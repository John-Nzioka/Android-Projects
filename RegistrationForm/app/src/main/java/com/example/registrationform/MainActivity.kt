package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase



class MainActivity : AppCompatActivity() {


    private lateinit var email_input: EditText
    private lateinit var password_input: EditText
    private lateinit var btn_user: Button
    private lateinit var register_user: Button
    private var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var firebasedatabase = FirebaseDatabase.getInstance()
        var databaseRef = firebasedatabase.reference

      mAuth = FirebaseAuth.getInstance()

        email_input = findViewById(R.id.edtemail)
        password_input = findViewById(R.id.edtpassword)
        btn_user = findViewById(R.id.btnlogin)
        register_user =findViewById(R.id.btncreate)
        register_user.setOnClickListener {
            var intent= Intent(this, SignupForm::class.java)
            startActivity(intent)
            finish()
        }

        btn_user.setOnClickListener {

            var email = email_input.text.toString().trim()
            var password = password_input.text.toString().trim()

            mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task: Task<AuthResult> ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "LOGGED IN SUCCESSFULLY", Toast.LENGTH_SHORT)
                            .show()
                        var intent = Intent(this, DashboardActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this, "LOG IN Failed", Toast.LENGTH_SHORT)
                            .show()
                        Log.d("Error-->", task.exception.toString())
                    }

                }

        }}}

