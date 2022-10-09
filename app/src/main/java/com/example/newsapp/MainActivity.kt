package com.example.newsapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bottomnavigationView = findViewById<BottomNavigationView>(R.id.bottomnavigation)
        navController = findNavController(this, R.id.nav_host_fragment)
        bottomnavigationView.setupWithNavController(navController)
 // this make back arrow and show fragment or activity name beside arraw
      NavigationUI.setupActionBarWithNavController(this, navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
    }
}
