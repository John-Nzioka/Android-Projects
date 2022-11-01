package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val usersList: List<User>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //get our list item from layout folder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }
    //view holder calling our xml Id
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = usersList[position]
        holder.txt_body.text = user.bodytext
        holder.txt_title.text = user.title
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, user.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
    //referencing from our layout xml file
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt_title: TextView = itemView.findViewById(R.id.txtTitle)
        val txt_body: TextView = itemView.findViewById(R.id.txtDescription)
    }
}

