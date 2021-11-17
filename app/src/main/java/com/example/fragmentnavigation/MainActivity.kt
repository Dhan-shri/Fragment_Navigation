package com.example.fragmentnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.fragmentnavigation.R.string.*
import com.example.fragmentnavigation.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var currentFragment: Fragment
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(LoginFragment(), null)

//        val Firstfragment = FirstFragment()
//        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, Firstfragment).commit()

        drawerLayout = findViewById(R.id.drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)





        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_first ->{
                    replaceFragment(LoginFragment(), null)
                }
                R.id.nav_second ->{
                    replaceFragment(SecondFragment(),null)
                }
                R.id.nav_third ->{
                    replaceFragment(ThirdFragment(),null)
                }
                R.id.nav_fourth ->{
                    replaceFragment(FourthFragment(),null)
                }
                R.id.nav_setting ->{
                    replaceFragment(SettingFragment(),null)
                }
                R.id.nav_spinner ->{
                    replaceFragment(SpinnerFragment(),null)
                }

            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true

        }

        // Bottom navigation code
        bottomNavigationView = findViewById(R.id.bottonNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.btm_first ->{
                    replaceFragment(LoginFragment(),null)
                    supportActionBar?.title= "Home"
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.btm_second ->{
                    replaceFragment(SecondFragment(),null)
                    supportActionBar?.title= "Dashboard"
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.btm_third ->{
                    replaceFragment(ThirdFragment(),null)
                    supportActionBar?.title ="Login"
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.btm_fourth -> {
                    replaceFragment(FourthFragment(),null)
                    supportActionBar?.title ="Info"
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false

        }

        replaceFragment(LoginFragment(),null)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }



    private fun replaceFragment(setFragment: Fragment, bundle: Bundle?) {
        currentFragment = setFragment
        val fragmentManager = supportFragmentManager
        if (bundle != null) {
            setFragment.arguments = bundle
        }
        val fragmentTra = fragmentManager.beginTransaction().addToBackStack(null)
        fragmentTra.replace(R.id.fragment_container, setFragment)
        fragmentTra.commit()

    }




}

