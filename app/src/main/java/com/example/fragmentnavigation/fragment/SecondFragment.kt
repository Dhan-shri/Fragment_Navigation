package com.example.fragmentnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.fragmentnavigation.R

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container,false)

//        val display: TextView = view.findViewById(R.id.displyMessage)
//
//        //fetch data
//        val args = this.arguments
//        val inputData = args?.get("data")
//        display.text = inputData.toString()

        val display: TextView = view.findViewById(R.id.disply)

        val args = this.arguments
        val inputData = args?.get("welcome")
        display.text = "**Welcome  "+inputData.toString()+" **"


        val butSec : Button = view.findViewById(R.id.butSec)
        butSec.setOnClickListener {
            val fragment = ThirdFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragment)?.commit()
        }
        return view
    }
}