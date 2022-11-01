package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recycle:RecyclerView = findViewById(R.id.recycUser)

        val user1 = User( "John Paul","Actor" )
        val user2 = User( "The Rock","Action Actor" )
        val user3 = User( "Denzel Washington","Actor" )
        val user4 = User( "Morgan Freeman","Action Actor" )
        val user5 = User( "Samuel Jackson","Actor" )
        val user6 = User( "Will Smith","Action Actor" )
        val user7 = User( "Bruce Willis","Actor" )
        val user8 = User( "Eddie Murphy","Action Actor" )
        val user9 = User( "Nicolas Cage","Actor" )
        val user10 = User( "Keanu Reeves","Action Actor" )

        val usersList = ArrayList<User>()
        usersList.add(user1)
        usersList.add(user2)
        usersList.add(user3)
        usersList.add(user4)
        usersList.add(user5)
        usersList.add(user6)
        usersList.add(user7)
        usersList.add(user8)
        usersList.add(user9)
        usersList.add(user10)
        

        var Adapter =CustomAdapter(usersList)
        recycle.layoutManager = LinearLayoutManager(this)
        recycle.adapter = Adapter




    }
}