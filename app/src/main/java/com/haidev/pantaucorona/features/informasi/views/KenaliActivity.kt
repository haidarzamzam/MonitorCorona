package com.haidev.pantaucorona.features.informasi.views

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.haidev.pantaucorona.R
import kotlinx.android.synthetic.main.activity_kenali.*

class KenaliActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_kenali)

        btnBackKenali.setOnClickListener {
            finish()
        }
    }
}
