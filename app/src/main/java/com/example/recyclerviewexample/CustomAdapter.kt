package com.example.recyclerviewexample

import android.content.ClipDescription
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    private var context: Context,
    private var cityNames: ArrayList<String>,
    private var cityContacts: ArrayList<String>,
    private var cityDescription: ArrayList<String>,
): RecyclerView.Adapter<CustomAdapter.MyViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return MyViewHolder(v)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // set the data in items
        holder.name.text = cityNames[position]
        holder.contact.text = cityContacts[position]
        holder.description.text = cityDescription[position]
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener { // display a toast with person name on item click
            Toast.makeText(context, cityNames[position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return cityNames.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById<View>(R.id.tvName) as TextView
        var contact: TextView = itemView.findViewById<View>(R.id.tvEmail) as TextView
        var description: TextView = itemView.findViewById<View>(R.id.tvDescription) as TextView
    }
}