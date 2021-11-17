package com.example.fragmentnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.fragmentnavigation.R

class FourthFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fourth, container,false)

        val btnfourth: Button = view.findViewById(R.id.btnfourth)
        btnfourth.setOnClickListener {
            val fragment= LoginFragment()

            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragment)?.commit()

        }

        return view
    }


}