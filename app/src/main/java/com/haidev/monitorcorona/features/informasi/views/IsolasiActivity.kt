package com.haidev.monitorcorona.features.informasi.views

import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.haidev.monitorcorona.R
import kotlinx.android.synthetic.main.activity_isolasi.*

class IsolasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_isolasi)
        setSupportActionBar(toolbarIsolasi)

        var isShow = true
        var scrollRange = -1
        appBarIsolasi.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1) {
                scrollRange = barLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset == 0) {
                collapsing_toolbar.title = "Panduan Isolasi Mandiri"
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                toolbarIsolasi.setNavigationIcon(R.drawable.ic_arrow_24dp)
                isShow = true
            } else if (isShow) {
                collapsing_toolbar.title = " "
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                isShow = false
            }
        })
        btnBackIsolasi.setOnClickListener {
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
