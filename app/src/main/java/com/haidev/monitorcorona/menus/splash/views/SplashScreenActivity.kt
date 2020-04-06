package com.haidev.monitorcorona.menus.splash.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.haidev.monitorcorona.R
import com.haidev.monitorcorona.main.views.MainActivity
import com.haidev.monitorcorona.menus.firstime.views.FirstTimeActivity
import com.haidev.monitorcorona.preferences.AppModel
import com.haidev.monitorcorona.preferences.AppPreference

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var mAppPreference: AppPreference
    private lateinit var appModel: AppModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_splash_screen)

        mAppPreference = AppPreference(this)
        appModel = mAppPreference.getPref()

        Handler().postDelayed({

            if (appModel.location != "") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, FirstTimeActivity::class.java))
                finish()
            }
        }, 2000)
    }
}
