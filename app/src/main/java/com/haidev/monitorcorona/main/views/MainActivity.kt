package com.haidev.monitorcorona.main.views

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.haidev.monitorcorona.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var BACK_PRESSED: Long = 0L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.fragment).navigateUp()
    }

    private fun setupNavigation() {
        val navController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupWithNavController(navigationView, navController)
    }

    override fun onBackPressed() {
        if ((BACK_PRESSED + 2000L) > System.currentTimeMillis()) {
            finish()
        } else {
            Toast.makeText(this, "Tekan Sekali Lagi", Toast.LENGTH_SHORT).show()
        }
        BACK_PRESSED = System.currentTimeMillis()
    }
}
