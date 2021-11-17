package com.example.fragmentnavigation.adaptr

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentnavigation.Name
import com.example.fragmentnavigation.R

class AdapterClass(val ctx:Context, val nameList: List<Name>) : RecyclerView.Adapter<AdapterClass.NameViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_layout,parent,false)
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.tvName.text = nameList[position].Name
        holder.tvNameYear.text = nameList[position].year.toString()

    }

    override fun getItemCount(): Int {
        return nameList.size
    }

   inner class NameViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView),View.OnClickListener {
       val tvName :TextView = itemView.findViewById(R.id.tvName)
       val tvNameYear:TextView = itemView.findViewById(R.id.tvNameYear)
       override fun onClick(p0: View?) {
           when (p0?.id) {
               R.id.mainLayout ->{
                   val NAME = nameList[adapterPosition].Name
                   Toast.makeText(ctx , NAME, Toast.LENGTH_LONG).show()
               }
           }
       }
   }

}



