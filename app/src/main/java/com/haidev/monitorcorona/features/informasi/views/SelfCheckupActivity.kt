package com.haidev.monitorcorona.features.informasi.views

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.haidev.monitorcorona.R

class SelfCheckupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_self_checkup)
    }
}
