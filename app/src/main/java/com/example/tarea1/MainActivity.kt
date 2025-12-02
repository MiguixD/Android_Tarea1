package com.example.tarea1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        fun onSupportNavigateUp(): Boolean
        {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_graph)
                        as NavHostFragment

            val navController = navHostFragment.navController

            return navController.navigateUp() ||
                    super.onSupportNavigateUp()
        }
    }
}