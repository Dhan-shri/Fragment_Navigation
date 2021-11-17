package com.example.fragmentnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentnavigation.Name
import com.example.fragmentnavigation.R
import com.example.fragmentnavigation.adaptr.AdapterClass

class SettingFragment : Fragment() {

    private val nameList = listOf(
        Name("Dhanshri",2001),
        Name("Manshri",2002),
        Name("Khooshbu",2003),
        Name("Komal",2004),
        Name("anita",2005),
        Name("Dhanshri",2001),
        Name("Manshri",2002),
        Name("Khooshbu",2003),
        Name("Komal",2004),
        Name("anita",2005),
        Name("Dhanshri",2001),
        Name("Manshri",2002),
        Name("Khooshbu",2003),
        Name("Komal",2004),
        Name("anita",2005),
        Name("Dhanshri",2001),
        Name("Manshri",2002),
        Name("Khooshbu",2003),
        Name("Komal",2004),
        Name("anamika",2005)
    )

    lateinit var rvView:RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvView = view.findViewById(R.id.rvView)
        layoutManager = LinearLayoutManager(requireActivity())
        rvView.layoutManager = layoutManager

        val adapterClass = AdapterClass(requireActivity(),nameList)
        rvView.adapter = adapterClass

    }


}