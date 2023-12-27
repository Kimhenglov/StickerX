package com.example.myapplication.youtubeVD.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        ////YouTube
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = Navigation.findNavController(this, R.id.lytFragment)

        NavigationUI.setupWithNavController(bottomNavigation,navController)
        ////YouTube // End

    }

}
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//
//        // Assuming you have a NavHostFragment with the ID "lytFragment"
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.lytFragment) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        NavigationUI.setupWithNavController(bottomNavigation, navController)
//    }
//}
