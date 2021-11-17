package com.example.fragmentnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.fragmentnavigation.R

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container,false)


        val btnThird: Button = view.findViewById(R.id.btnThird)
        btnThird.setOnClickListener {

            val mobile: EditText = view.findViewById(R.id.Mobile)
            val mobile1= mobile.text.toString()
            val Pass : EditText = view.findViewById(R.id.Pass)
            val Pass1= Pass.text.toString()
            if ( mobile1.length==10 && Pass1.length==5){
                val fragment= FourthFragment()
                fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragment)?.commit()

            }else {
                Toast.makeText(context, "Enter Correct mobile number and 5 digit password", Toast.LENGTH_LONG).show()

            }



        }
        return view
    }


}
