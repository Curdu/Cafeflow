package com.curdu.cafeflow.a_views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.curdu.cafeflow.R
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.curdu.cafeflow.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        navController = navHostFragment.navController

        setupWithNavController(binding.bottomNavigationView, navController)
    }
}