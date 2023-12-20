package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragment.CategoryFragment2
import com.example.myapplication.fragment.FavoriteFragment2
import com.example.myapplication.fragment.HomeFragment2

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Show Fragment
        showFragment(HomeFragment2())

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_homeFragment -> showFragment(HomeFragment2())
                R.id.menu_favoriteFragment -> showFragment(FavoriteFragment2())
                R.id.menu_categoryFragment -> showFragment(CategoryFragment2())
//                else -> showFragment(MoreFragment())
            }

            true
        }
    }

    fun showFragment(fragment: Fragment){
        // Fragment

        val fragmentTransition = supportFragmentManager.beginTransaction()

        //Replace fragment in lytFragment
        fragmentTransition.replace(R.id.lytFragment, fragment)

        // Commit transition

        fragmentTransition.commit()
    }
}