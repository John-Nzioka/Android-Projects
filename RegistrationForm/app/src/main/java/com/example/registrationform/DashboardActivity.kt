package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {
    private lateinit var logoutbtn:Button
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        logoutbtn=findViewById(R.id.btnlogout)
        mAuth=FirebaseAuth.getInstance()

        logoutbtn.setOnClickListener {

            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show()
            var inntett=Intent(this, MainActivity::class.java)
            startActivity(inntett)
            finish()
        }
    }
}