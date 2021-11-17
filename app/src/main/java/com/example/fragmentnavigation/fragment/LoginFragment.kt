package com.example.fragmentnavigation.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.fragmentnavigation.R


class LoginFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var userId :String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_login, container,false)

//        val sendBtn: Button = view.findViewById(R.id.sendBtn)
//        sendBtn.setOnClickListener {
//            val messageInput:EditText = view.findViewById(R.id.messageInput)
//            val Input = messageInput.text.toString()
//
//            val bundle = Bundle()
//            bundle.putString("data", Input)
//            // want to transfer to second fragment
//
//            val fragment = SecondFragment()
//            fragment.arguments = bundle
//            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragment)?.commit()
//
//        }


        val sendBtn: Button = view.findViewById(R.id.sendBtn)
        sendBtn.setOnClickListener {
            val useId: EditText = view.findViewById(R.id.useId)
            val userId = useId.text.toString()
            val pass :EditText = view.findViewById(R.id.Password)
            val pass1 = pass.text.toString()

            val bundle = Bundle()
            bundle.putString("welcome", userId)


            val secondFragment = SecondFragment()
            secondFragment.arguments=bundle




//                val fragmentManager: androidx.fragment.app.FragmentManager? = fragmentManager
//                fragmentManager!!.beginTransaction()
//                    .replace(R.id.fragment_container,secondFragment)
//                    .addToBackStack(null)
//                    .commit()
//
            if (pass1.length==5){
                val fragment = SecondFragment()
                fragment.arguments= bundle
                fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragment)?.commit()
            } else {
                Toast.makeText(context, "Enter 5 digit passward", Toast.LENGTH_LONG).show()

            }

            val editor =sharedPreferences.edit()
            editor.putString("UserId", userId)
            editor.apply()



        }





        val signUp:Button = view.findViewById(R.id.signUp)
        signUp.setOnClickListener {
            val fragment= ThirdFragment()

            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragment)?.commit()


        }
        return view
    }



}
