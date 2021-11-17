package com.example.fragmentnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.fragmentnavigation.R


class SpinnerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sppiner,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val spinner = view.findViewById<Spinner>(R.id.mySpinner)
        val state= resources.getStringArray(R.array.State)

        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1, state)

        spinner.adapter = adapter


        spinner.onItemSelectedListener

    }
}